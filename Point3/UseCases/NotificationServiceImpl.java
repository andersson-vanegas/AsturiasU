package Point3.UseCases;

import Point3.Gateway;
import Point3.Interface.NotificationService;
import Point3.RateLimiter;

import java.time.Duration;

public class NotificationServiceImpl implements NotificationService {
    private Gateway gateway;
    private RateLimiter rateLimiter;

    public NotificationServiceImpl(Gateway gateway) {
        this.gateway = gateway;
        this.rateLimiter = new RateLimiter();
    }

    @Override
    public void send(String type, String userId, String message) {
        int limit = 0;
        Duration period = Duration.ZERO;

        switch (type) {
            case "status":
                limit = 2;
                period = Duration.ofMinutes(1);
                break;
            case "news":
                limit = 1;
                period = Duration.ofDays(1);
                break;
            case "marketing":
                limit = 3;
                period = Duration.ofHours(1);
                break;
        }

        if (rateLimiter.grantAccess(userId, type, limit, period)) {
            gateway.send(userId, message);
        } else {
            System.out.println("Rate limit exceeded for " + userId);
        }
    }
    }