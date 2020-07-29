# cron-schedule
Java cron schedule with springboot

#A Cron expression consists of six sequential fields
second, minute, hour, day of month, month, day(s) of week

and is declared as follows :
@Scheduled(cron = "* * * * * *")

We can also set the timezone as :
@Scheduled(cron="* * * * * *", zone="Asia/Jakarta")

