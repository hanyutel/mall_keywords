package cn.hanyuweb.utils;

import org.apache.solr.client.solrj.impl.HttpSolrServer;
import org.apache.solr.client.solrj.impl.XMLResponseParser;

import cn.hanyuweb.util.LoadPropertyUtil;

public class MySolrUtil {
	static HttpSolrServer server = null;
	static{
		server=new HttpSolrServer(LoadPropertyUtil.load("solr.properties", "solr_sku_url"));
		server.setParser(new XMLResponseParser());
		server.setConnectionTimeout(20000);
	}
	public static HttpSolrServer  getSolr(){
		return server;
	}
}
