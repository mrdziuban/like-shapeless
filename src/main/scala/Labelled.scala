package likeShapeless

opaque type ->>[K, +V] = V
object ->> {
  implicit def convertToV[K, V](kv: K ->> V): V = kv
}

extension[K <: Singleton](k: K) {
  inline final def ->>[V](v: V): K ->> V = v
}
