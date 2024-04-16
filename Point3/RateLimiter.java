package Point3;

import java.time.Duration;
import java.time.LocalDateTime;
import java.util.Deque;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.Map;

public class RateLimiter {

    private Map<String, Deque<LocalDateTime>> timestamps = new HashMap<>();
    public boolean grantAccess(String userId, String type, int limit, Duration period) {
        String key = type + ":" + userId;
        Deque<LocalDateTime> queue = timestamps.getOrDefault(key, new LinkedList<>());
        LocalDateTime now = LocalDateTime.now();

        while (!queue.isEmpty() && Duration.between(queue.getFirst(), now).compareTo(period) > 0) {
            queue.removeFirst();
        }

        if (queue.size() < limit) {
            queue.addLast(now);
            timestamps.put(key, queue);
            return true;
        } else {
            return false;
        }
    }
}
