package com.yousoft.cfapi.entity.model;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

import com.yousoft.cfapi.entity.Pubcontent;

public class FContentView {

	private String textid;

	private String content;

	private String photolist;

	private String zfurl;

	private String pubtime;

	public FContentView() {
	}

	public FContentView(Pubcontent content) {
		this.textid = content.getCtid().toString();
		this.content = content.getText();
		this.photolist = content.getPhoto();
		this.zfurl = content.getUrl();
		this.pubtime = parseTime(content.getPubtime());
	}

	public String getTextid() {
		return textid;
	}

	public void setTextid(String textid) {
		this.textid = textid;
	}

	public String getContent() {
		return content;
	}

	public void setContent(String content) {
		this.content = content;
	}

	public String getPhotolist() {
		return photolist;
	}

	public void setPhotolist(String photolist) {
		this.photolist = photolist;
	}

	public String getZfurl() {
		return zfurl;
	}

	public void setZfurl(String zfurl) {
		this.zfurl = zfurl;
	}

	public String getPubtime() {
		return pubtime;
	}

	public void setPubtime(String pubtime) {
		this.pubtime = pubtime;
	}

	private String parseTime(Date date) {
		Calendar nowCal = Calendar.getInstance();
		Calendar pubCal = Calendar.getInstance();
		pubCal.setTime(date);

		if (nowCal.get(Calendar.DATE) == pubCal.get(Calendar.DATE)
				&& nowCal.get(Calendar.MONTH) == pubCal.get(Calendar.MONTH)
				&& nowCal.get(Calendar.YEAR) == pubCal.get(Calendar.YEAR)) {
			return "今天";
		} else {
			pubCal.add(Calendar.DATE, 1);
			if (pubCal.get(Calendar.DATE) == nowCal.get(Calendar.DATE)) {
				return "昨天";
			} else {
				SimpleDateFormat format = new SimpleDateFormat("mm-dd");
				return format.format(date);
			}
		}
	}

}
