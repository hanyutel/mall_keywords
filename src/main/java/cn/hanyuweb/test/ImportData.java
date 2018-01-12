package cn.hanyuweb.test;

import java.io.InputStream;
import java.io.Reader;
import java.util.List;

import org.apache.ibatis.session.Configuration;
import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.solr.client.solrj.ResponseParser;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.apache.solr.common.params.SolrParams;
import org.apache.solr.common.util.NamedList;

import cn.hanyuweb.bean.OBJECT_T_MALL_SKU_KEYWORDS;
import cn.hanyuweb.mapper.ImportDataMapper;
import cn.hanyuweb.util.LoadPropertyUtil;
import cn.hanyuweb.utils.SqlSessionFactoryUtil;

public class ImportData {

	public static void main(String[] args) throws Exception {
		SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
		SqlSession openSession = sqlSessionFactory.openSession();
		ImportDataMapper mapper = openSession.getMapper(ImportDataMapper.class);
		List<OBJECT_T_MALL_SKU_KEYWORDS> sku_list = mapper.select_sku_list_by_class_2_id(28);
		
		HttpSolrServer server = new HttpSolrServer(LoadPropertyUtil.load("solr.properties", "solr_sku_url"));
		server.setParser(new XMLResponseParser());
		server.setConnectionTimeout(20000);
		
//		server.addBeans(sku_list);
//		server.commit();
		
		 SolrQuery squery = new SolrQuery();
		 squery.setQuery("sku_mch:小明");
		QueryResponse query = server.query(squery);
		List<OBJECT_T_MALL_SKU_KEYWORDS> list = query.getBeans(OBJECT_T_MALL_SKU_KEYWORDS.class);
		System.out.println(list);
	}

}
