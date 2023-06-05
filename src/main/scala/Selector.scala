package likeShapeless

trait Selector[A, Key] {
  type Out
  def apply(a: A): Out
}

object Selector {
  type Aux[A, K, O] = Selector[A, K] { type Out = O }

  inline def apply[A, T](using s: Selector[A, T]): Aux[A, T, s.Out] = s

  type FindField[T <: Tuple, K] = FindField0[T, K, 0]

  type FindField0[T <: Tuple, K, I <: Int] <: (Any, Int) = T match {
    case (K ->> f) *: _ => (f, I)
    case _ *: t => FindField0[t, K, compiletime.ops.int.S[I]]
  }

  inline given selectorInst[T <: Tuple, K](
    using idx: ValueOf[Tuple.Elem[FindField[T, K], 1]],
  ): Selector.Aux[T, K, Tuple.Head[FindField[T, K]]] =
    new Selector[T, K] {
      type Out = Tuple.Head[FindField[T, K]]
      def apply(t: T): Out = t.productElement(idx.value).asInstanceOf[Out]
    }
}