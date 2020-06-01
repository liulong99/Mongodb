package com.tjx.springdata_mongodb;

import com.mongodb.client.result.UpdateResult;
import com.tjx.springdata_mongodb.entity.Cart;
import com.tjx.springdata_mongodb.entity.Comment;
import com.tjx.springdata_mongodb.entity.Goods;
import com.tjx.springdata_mongodb.service.CommentService;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.mongodb.core.MongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.test.context.junit4.SpringRunner;

import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;


@RunWith(SpringRunner.class)
@SpringBootTest
class SpringdataMongodbApplicationTests {


	@Autowired
	private CommentService commentService;

	@Autowired
	private MongoTemplate mongoTemplate;



	@Test
	void testSaveAll(){
		List<Comment> comments=new ArrayList<>();
		comments.add(new Comment("1001","写得很好，赞",new Date(),"888","苏沐秋", LocalDateTime.now(),40,20,"0","","10038"));
		comments.add(new Comment("1002","收获很大",new Date(),"999","苏沐橙", LocalDateTime.now(),40,20,"0","","10038"));
		commentService.saveAll(comments);
	}

	@Test
	List<Comment> testFindAll(){
//		如果要设置ReadConcern或者writeConcern
//		mongoTemplate.getCollection("cart").withReadConcern(ReadConcern.MAJORITY);
		return commentService.findAll();
	}



	//插入购物车
	@org.junit.jupiter.api.Test
	public void insertCart(){
		List<String> list=new ArrayList<>();
		list.add("mianbao.jpg");

		List<Goods> goods=new ArrayList<>();
		Goods goods1=new Goods("1000","mianbao",5.00,1,list);
		goods.add(goods1);

		Cart cart=new Cart("1000",new Date(),"active",goods);
		Cart insert = mongoTemplate.insert(cart);
		System.out.println(insert);
	}


	//更细商品数量
	@org.junit.jupiter.api.Test
	public void updateCart(){
		List<String> list=new ArrayList<>();
		list.add("mianbao.jpg");

		List<Goods> goods=new ArrayList<>();
		Goods goods1=new Goods("1000","mianbao",5.00,1,list);
		goods.add(goods1);

		Cart cart=new Cart("1000",new Date(),"active",goods);
		cart.setId("5e96aa9f3bbe036e72bbc946");
		//上面cart模拟从MongoDB查询出来对象

		Query query = new Query();
		query.addCriteria(Criteria.where("_id").is(cart.getId()));
		query.addCriteria(Criteria.where("goods.itemId").is("1000"));

//		mongoTemplate.executeQuery(query, "cart", new DocumentCallbackHandler() {
//			@Override
//			public void processDocument(Document document) throws MongoException, DataAccessException {
//				System.out.println(document);
//			}
//		});
		Update update = new Update();
		update.set("goods.$.quantity", 5);
		update.set("last_activity", new Date());
		UpdateResult updateResult = mongoTemplate.updateFirst(query, update, Cart.class);
		System.out.println(updateResult.getMatchedCount());
	}
}
