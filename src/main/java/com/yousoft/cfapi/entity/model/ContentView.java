package com.yousoft.cfapi.entity.model;

import java.util.Date;
import java.util.List;

import com.yousoft.cfapi.entity.Pubcontent;

/**
 * 个人列表
 * 
 * @author jiangweiyang01
 */
public class ContentView {
	// 评论人数
	private int plcount;
	// 赞人数
	private int zancount;
	// 发布时间
	private String pubtime;
	// 转发URL
	private String zfurl;
	// 照片列表
	private String photolist;
	// 发布内容
	private String content;
	// 文本ID
	private String textid;
	// 发布者ID
	private String pubuserid;
	// 点赞人数集合.
	private List<String> zanlist;
	// 评论信息集合
	private List<PlView> pldetails;

	public ContentView() {
	}

	public ContentView(Pubcontent content) {
		this.pubuserid = content.getPubuid();
		this.textid = content.getCtid().toString();
		this.content = content.getText();
		this.photolist = content.getPhoto();
		this.zfurl = content.getUrl();
		// 解析当前时间
		this.pubtime = formatTime(content.getPubtime());
		this.zancount = content.getZancount().intValue();
		this.plcount = content.getPlcount().intValue();
	}

	public List<String> getZanlist() {
		return zanlist;
	}

	public void setZanlist(List<String> zanlist) {
		this.zanlist = zanlist;
	}

	public List<PlView> getPldetails() {
		return pldetails;
	}

	public void setPldetails(List<PlView> pldetails) {
		this.pldetails = pldetails;
	}

	public int getPlcount() {
		return plcount;
	}

	public void setPlcount(int plcount) {
		this.plcount = plcount;
	}

	public int getZancount() {
		return zancount;
	}

	public void setZancount(int zancount) {
		this.zancount = zancount;
	}

	public String getPubtime() {
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	public String getZfurl() {
		return zfurl;
	}

	public void setZfurl(String zfurl) {
		this.zfurl = zfurl;
	}

	public String getPhotolist() {
		return photolist;
	}

	public void setPhotolist(String photolist) {
		this.photolist = photolist;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getTextid() {
		return textid;
	}

	public void setTextid(String textid) {
		this.textid = textid;
	}

	public String getPubuserid() {
		return pubuserid;
	}

	public void setPubuserid(String pubuserid) {
		this.pubuserid = pubuserid;
	}

	/**
	 * 格式化时间
	 * 
	 * @param pubTime
	 *            格式化时间
	 * @return
	 */
	private String formatTime(Date pubTime) {
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
