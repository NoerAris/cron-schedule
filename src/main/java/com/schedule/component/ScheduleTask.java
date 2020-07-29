package com.schedule.component;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.scheduling.annotation.Scheduled;
import org.springframework.stereotype.Component;
import java.time.format.DateTimeFormatter;
//import java.util.concurrent.TimeUnit;
import java.time.LocalDateTime;

@Component
public class ScheduleTask {

	private static final Logger log = LoggerFactory.getLogger(ScheduleTask.class);
	
	private static final DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("HH:mm:ss");
	
	//Fires every 2 second
	@Scheduled(fixedRate = 2000)
	public void scheduleTaskWithFixedRate() {
		log.info("Fixed Rate Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()) );
	}
	
	//Delay every 3 second
	@Scheduled(fixedDelay = 3000)
	public void scheduleTaskWithFixedDelay() {
		log.info("Fixed Delay Task :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
		//Sleep TimeUnit
//		try {
//			TimeUnit.SECONDS.sleep(5);
//		} catch (Exception e) {
//			log.error("Ran into an error {}", e);
//	        throw new IllegalStateException(e);
//		}
	}
	
	//First initial delay 5 second, then run normal every 2 second
	@Scheduled(fixedRate = 2000, initialDelay = 5000)
	public void scheduleTaskWithInitialDelay() {
		log.info("Fixed Rate  Task With Initial Delay :: Execution Time - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}

	//Fires at 14:09 every day:
	@Scheduled(cron = "0 09 14 * * ?")
    public void scheduleTaskWithCronExpression() {
		log.info("Cron Task :: Execution Time Every 14:09 - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}
	
	//Fires the top of every hour of every day
	@Scheduled(cron = "0 0 * * * *")
    public void scheduleTaskYear() {
		log.info("Cron Task :: Execution Time Every Hour of Every Day - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}
	
	//Fires every 20 seconds
	@Scheduled(cron = "0/20 * * * * *")
    public void scheduleTaskSecond() {
		log.info("Cron Task :: Execution Time Every 20 Second - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}
	
	//Fires every 8, 9 and 10 o'clock of every day.
	@Scheduled(cron = "0 0 8-10 * * *")
	public void scheduleTaskHourly() {
		log.info("Cron Task :: Execution Time Every 8 - 10 O'clock Every Day  - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}
	
	//Fires every 8, 9 and 10 o'clock of every day.
	@Scheduled(cron = "0 0/30 8-9 * * *")
	public void scheduleTaskCustomHourly() {
		log.info("Cron Task :: Execution Time Every 8:00, 8:30, 9:00, 9:30  O'clock Every Day  - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}
	
	//Fires every 8 - 17 o'clock of every weekdays.
	@Scheduled(cron = "0 0 9-17 * * MON-FRI")
	public void scheduleTaskWeekly() {
		log.info("Cron Task :: Execution Time Every 9 - 17 O'clock Every Weekdays  - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}
	
	//Fires on every 17 August
	@Scheduled(cron = "0 0 10 17 8 ?")
	public void scheduleTaskYearly() {
		log.info("Cron Task :: Execution Time Every 10:00 o'clock in 17 August - {}", dateTimeFormatter.format(LocalDateTime.now()));
	}
}
