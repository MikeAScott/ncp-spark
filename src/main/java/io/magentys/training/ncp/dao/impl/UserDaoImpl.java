package io.magentys.training.ncp.dao.impl;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.sql.DataSource;

import org.mongodb.morphia.Datastore;
import org.mongodb.morphia.mapping.Mapper;
import org.mongodb.morphia.query.Query;
import org.mongodb.morphia.query.UpdateOperations;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.jdbc.core.namedparam.NamedParameterJdbcTemplate;
import org.springframework.stereotype.Repository;

import io.magentys.training.ncp.dao.UserDao;
import io.magentys.training.ncp.model.User;
import io.magentys.training.ncp.util.GravatarUtil;

@Repository
public class UserDaoImpl implements UserDao {
	
	private Datastore datastore;
	@Autowired
	public UserDaoImpl(Datastore datastore) {
		this.datastore = datastore;
	}

	@Override
	public User getUserbyUsername(String username) {
		Query<User> query = datastore.createQuery(User.class)
				.filter("username =", username);
		return query.get();
	}

	@Override
	public void insertFollower(User follower, User followee) {
		Query<User> query = datastore.createQuery(User.class)
			.field(Mapper.ID_KEY).equal(follower.getId());
		UpdateOperations<User> ops = datastore.createUpdateOperations(User.class)
			.add("follows", followee.getUsername());
		datastore.update(query, ops);
//		Map<String, Object> params = new HashMap<String, Object>();
//        params.put("follower", follower.getId());
//        params.put("followee", followee.getId());
//        
//		String sql = "insert into follower (follower_id, followee_id) values (:follower, :followee)";
//		
//        template.update(sql,  params);
	}

	@Override
	public void deleteFollower(User follower, User followee) {
//		Map<String, Object> params = new HashMap<String, Object>();
//        params.put("follower", follower.getId());
//        params.put("followee", followee.getId());
//        
//		String sql = "delete from follower where follower_id = :follower and followee_id = :followee";
//		
//        template.update(sql,  params);
	}
	
	@Override
	public boolean isUserFollower(User follower, User followee) {
		return false;
//		Map<String, Object> params = new HashMap<String, Object>();
//        params.put("follower", follower.getId());
//        params.put("followee", followee.getId());
//        
//		String sql = "select count(1) from follower where " +
//            "follower.follower_id = :follower and follower.followee_id = :followee";
//		
//		Long l = template.queryForObject(sql, params, Long.class);
//		
//		return l > 0;
	}

	@Override
	public void registerUser(User user) {
		user.setGravatar(GravatarUtil.gravatarURL(user.getEmail(),
				GravatarUtil.GRAVATAR_DEFAULT_IMAGE_TYPE,
				GravatarUtil.GRAVATAR_SIZE));		
		datastore.save(user);
	}

}
