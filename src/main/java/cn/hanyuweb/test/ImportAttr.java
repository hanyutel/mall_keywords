package cn.hanyuweb.test;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;

import cn.hanyuweb.bean.OBJECT_T_MALL_ATTR_KEYWORDS;
import cn.hanyuweb.mapper.AttrMapper;
import cn.hanyuweb.util.LoadPropertyUtil;
import cn.hanyuweb.utils.SqlSessionFactoryUtil;

public class ImportAttr {

	public static void main(String[] args) {
		try {
			SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
			SqlSession session = sqlSessionFactory.openSession();
			AttrMapper mapper = session.getMapper(AttrMapper.class);
			List<OBJECT_T_MALL_ATTR_KEYWORDS> attrList = mapper.select_attr_list_keywords(28);

			HttpSolrServer server = new HttpSolrServer(LoadPropertyUtil.load("solr.properties", "solr_value_url"));
			server.setParser(new XMLResponseParser());
			server.setConnectionTimeout(60000);
//			server.addBeans(attrList);
//			server.commit();
			SolrQuery query = new SolrQuery();
			query.setQuery("copy_item:像素");
			query.setRows(100);
			query.setStart(1);
			QueryResponse query2 = server.query(query);
			List<OBJECT_T_MALL_ATTR_KEYWORDS> beans = query2.getBeans(OBJECT_T_MALL_ATTR_KEYWORDS.class);
			System.out.println(beans);
		} catch (Exception e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}

}
