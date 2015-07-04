package com.yousoft.cfapi.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.yousoft.cfapi.dao.RelationMapper;
import com.yousoft.cfapi.entity.Relation;
import com.yousoft.cfapi.entity.RelationExample;
import com.yousoft.cfapi.entity.RelationExample.Criteria;
import com.yousoft.cfapi.service.PrivilegeService;
import com.yousoft.cfapi.util.ArchState;

@Service
public class PrivilegeServiceImpl implements PrivilegeService {

	@Autowired
	private RelationMapper relationMapper;

	@Override
	public int proOthersList(String userid, String destuserid, String value) {
		RelationExample example = new RelationExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserfromEqualTo(userid);
		criteria.andUsertoEqualTo(destuserid);
		List<Relation> relationList = relationMapper.selectByExample(example);
		if (relationList == null) {
			return PrivilegeService.NOTFOUND;
		} else if (relationList.size() > 1) {
			return PrivilegeService.MORERELATION;
		} else {
			// 获取第一个关系对象
			Relation relation = relationList.get(0);
			if (relation != null) {
				relation.setFlag1(value);
				relationMapper.updateByExampleSelective(relation, example);
			}
			return ArchState.SUCCESS.getState();
		}
	}

	@Override
	public int proSelfToOthers(String userid, String destuserid, String value) {
		RelationExample example = new RelationExample();
		Criteria criteria = example.createCriteria();
		criteria.andUserfromEqualTo(destuserid);
		criteria.andUsertoEqualTo(userid);
		List<Relation> relationList = relationMapper.selectByExample(example);
		if (relationList == null) {
			return PrivilegeService.NOTFOUND;
		} else if (relationList.size() > 1) {
			return PrivilegeService.MORERELATION;
		} else {
			// 获取第一个关系对象
			Relation relation = relationList.get(0);
			if (relation != null) {
				relation.setFlag2(value);
				relationMapper.updateByExampleSelective(relation, example);
			}
			return ArchState.SUCCESS.getState();
		}
	}

	@Override
	public int relationDeal(String userid, String destuserid, String type) {
		if ("0".equals(type)) {
			// 建立用用户关系
			RelationExample example = new RelationExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserfromEqualTo(userid);
			criteria.andUsertoEqualTo(destuserid);
			List<Relation> relationList = relationMapper
					.selectByExample(example);
			if (relationList == null) {
				Relation relation = new Relation();
				relation.setUserfrom(userid);
				relation.setUserto(destuserid);
				relationMapper.insertSelective(relation);
			}
		} else if ("1".equals(type)) {
			RelationExample example = new RelationExample();
			Criteria criteria = example.createCriteria();
			criteria.andUserfromEqualTo(userid);
			criteria.andUsertoEqualTo(destuserid);
			List<Relation> relationList = relationMapper
					.selectByExample(example);
			if (relationList != null && relationList.size() > 0) {
				relationMapper.deleteByExample(example);
			}
		}
		return ArchState.SUCCESS.getState();
	}

}
