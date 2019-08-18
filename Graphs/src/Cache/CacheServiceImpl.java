package Cache;

import java.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.atomic.AtomicBoolean;

public class CacheServiceImpl implements CacheService{

	public ConcurrentHashMap<String, Pair<AtomicBoolean, ConcurrentHashMap>> cacheMap = new ConcurrentHashMap<>();
}
