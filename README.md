To reproduce the issue, run `sbt console`, then paste the following code:

```scala
import likeShapeless._
summon[Selector.Aux[("s" ->> String) *: EmptyTuple, "s", String]]
```

You'll see an error:

```scala
-- [E172] Type Error: ----------------------------------------------------------
1 |summon[Selector.Aux[("s" ->> String) *: EmptyTuple, "s", String]]
  |                                                                 ^
  |No given instance of type likeShapeless.Selector.Aux[(("s" : String) ->> String) *: EmptyTuple,
  |  ("s" : String), String] was found for parameter x of method summon in object Predef
  |
  |The following import might fix the problem:
  |
  |  import likeShapeless.Selector.selectorInst
  |
1 error found
```
