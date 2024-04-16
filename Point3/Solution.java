package Point3;

import Point3.UseCases.NotificationServiceImpl;


class Solution {
    public static void main(String[] args) {
        Gateway gateway = new Gateway();
        NotificationServiceImpl service = new NotificationServiceImpl(gateway);
        service.send("news", "user", "news 1");
        service.send("news", "user", "news 2");
        service.send("news", "user", "news 3");
        service.send("news", "another user", "news 1");
        service.send("update", "user", "update 1");
    }

}