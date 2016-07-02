package  com.muhron.kollection

fun <TSource, TKey> Iterable<TSource>.multiGroupBy(keysSelector: (TSource) -> Iterable<TKey>): Map<TKey, List<TSource>> =
        flatMap { element -> keysSelector(element).map { key -> key.to(element) } }.groupBy({ it.first }, { it.second })

fun <TSource, TKey> Array<TSource>.multiGroupBy(keysSelector: (TSource) -> Array<TKey>): Map<TKey, List<TSource>> =
        flatMap { element -> keysSelector(element).map { key -> key.to(element) } }.groupBy({ it.first }, { it.second })

fun <TSource, TKey> Sequence<TSource>.multiGroupBy(keysSelector: (TSource) -> Sequence<TKey>): Map<TKey, List<TSource>> =
        flatMap { element -> keysSelector(element).map { key -> key.to(element) } }.groupBy({ it.first }, { it.second })

fun <TMKey, TMValue, TKey> Map<TMKey, TMValue>.multiGroupBy(keysSelector: (Map.Entry<TMKey, TMValue>) -> List<TKey>): Map<TKey, List<Map.Entry<TMKey, TMValue>>> =
        flatMap { element -> keysSelector(element).map { key -> key.to(element) } }.groupBy({ it.first }, { it.second })
