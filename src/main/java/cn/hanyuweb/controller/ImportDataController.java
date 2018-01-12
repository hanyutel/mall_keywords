package cn.hanyuweb.controller;

import java.util.List;

import org.apache.ibatis.session.SqlSession;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.solr.client.solrj.SolrQuery;
import org.apache.solr.client.solrj.SolrServerException;
import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;
import org.apache.solr.client.solrj.response.QueryResponse;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import cn.hanyuweb.bean.OBJECT_T_MALL_SKU_KEYWORDS;
import cn.hanyuweb.mapper.ImportDataMapper;
import cn.hanyuweb.util.LoadPropertyUtil;
import cn.hanyuweb.utils.MySolrUtil;
import cn.hanyuweb.utils.SqlSessionFactoryUtil;
@Controller
public class ImportDataController {
	@RequestMapping("search_solr_sku/{search_param}")
	@ResponseBody
	public List<OBJECT_T_MALL_SKU_KEYWORDS> search_solr_sku(@PathVariable String search_param){
		HttpSolrServer server = MySolrUtil.getSolr();
		List<OBJECT_T_MALL_SKU_KEYWORDS> list =null;
		SolrQuery squery = new SolrQuery();
		squery.setQuery("copy_item:"+search_param);
		squery.setRows(50);
		try {
			QueryResponse query = server.query(squery);
			list= query.getBeans(OBJECT_T_MALL_SKU_KEYWORDS.class);
		} catch (SolrServerException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return list;
	}
	
	@RequestMapping("init_sku")
	public void init_sku(){
		try {
			SqlSessionFactory sqlSessionFactory = SqlSessionFactoryUtil.getSqlSessionFactory();
			SqlSession openSession = sqlSessionFactory.openSession();
			ImportDataMapper mapper = openSession.getMapper(ImportDataMapper.class);
			List<OBJECT_T_MALL_SKU_KEYWORDS> sku_list = mapper.select_sku_list_by_class_2_id(28);
			
			HttpSolrServer server = new HttpSolrServer(LoadPropertyUtil.load("solr.properties", "solr_sku_url"));
			server.setParser(new XMLResponseParser());
			server.setConnectionTimeout(20000);
			server.addBeans(sku_list);
			server.commit();
			
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
