package com.yousoft.cfapi.util;

import java.util.Date;

public class TimeUtils {
	
	/**
	 * 格式化时间
	 * 
	 * @param pubTime
	 *            格式化时间
	 * @return
	 */
	public static String formatTime(Date pubTime) {
		Date nowDate = new Date();
		long pubTimeStamp = pubTime.getTime();
		long nowTimeStamp = nowDate.getTime();

		// 比较年
		long timeDiff = nowTimeStamp - pubTimeStamp;
		long years = timeDiff / (1000 * 60 * 60 * 24 * 365);
		if (years > 1) {
			return ((int) years) + "年前";
		} else {
			long months = timeDiff / (1000 * 60 * 60 * 24 * 30);
			if (months > 1 && months < 12) {
				return ((int) months) + "月前";
			} else {
				long days = timeDiff / (1000 * 60 * 60 * 24);
				if (days > 1 && months < 30) {
					return ((int) days) + "天前";
				} else {
					long hours = timeDiff / (1000 * 60 * 60);
					if (hours > 1 && hours < 24) {
						return ((int) hours) + "小时前";
					} else {
						long minutes = timeDiff / (1000 * 60);
						if (minutes > 1 && minutes < 60) {
							return ((int) minutes) + "分钟前";
						} else {
							return "刚刚";
						}
					}
				}
			}
		}
	}

}
