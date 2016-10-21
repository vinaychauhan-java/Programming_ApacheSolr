# Programming_ApacheSolr

Coding for Apache Solr using Spring Data

	-- ================================================
	-- Steps to Start/Configure Apache Solr
	-- ================================================
	C:\Apache-Solr-5.2.0\bin>solr start -p 8983
		Starting Solr on port 8983 from C:\Apache-Solr-5.2.0\server
		Direct your Web browser to http://localhost:8983/solr to visit the Solr Admin UI

	C:\Apache-Solr-5.2.0\bin>solr create -c SolrCore_1
		Setup new core instance directory:
		C:\Apache-Solr-5.2.0\server\solr\SolrCore_1

		Creating new core 'SolrCore_1' using command:
		http://localhost:8983/solr/admin/cores?action=CREATE&name=SolrCore_1&instanceDir
		=SolrCore_1
		{
		  "responseHeader":{
			"status":0,
			"QTime":4025},
		  "core":"SolrCore_1"}

	-- ================================================
	-- Solr Configuration
	-- ================================================
	In version 5.2 of Solr, the solrconfig.xml uses the ManagedIndexSchemaFactory as the schemaFactory. 
	However, we will use the ClassicIndexSchemaFactory for learning purpose as of now...

	-- ================================================
	-- (1) Configure Apache Solr to use "schema.xml"
	--	   Location:- $(Solr_Home)\server\solr\$(core_name)\conf
	-- ================================================
	Copy managed-schema schema.xml
	
	-- Add following elements for working example "Programming_ApacheSolr" :-
		<field name="title" type="string" indexed="true" stored="true" required="false" multiValued="false" />
		<field name="description" type="string" indexed="true" stored="true" required="false" multiValued="false" />

	-- ================================================
	-- (2) Configure Apache Solr : solrconfig.xml
	--	   Location:- $(Solr_Home)\server\solr\$(core_name)\conf\solrconfig.xml
	-- ================================================
	<!--
	<schemaFactory class="ManagedIndexSchemaFactory">
		<bool name="mutable">true</bool>
		<str name="managedSchemaResourceName">managed-schema</str>
	</schemaFactory>
	-->
	<schemaFactory class="ClassicIndexSchemaFactory"/>
 	
	-- ================================================
	-- (3) Comment the aggregate for solr.AddSchemaFieldsUpdateProcessorFactory in solrconfig.xml
	--	   Location:- $(Solr_Home)\server\solr\$(core_name)\conf\solrconfig.xml
	-- ================================================
	<processor class="solr.AddSchemaFieldsUpdateProcessorFactory">
      ...
	  <str name="defaultFieldType">strings</str>
      <lst name="typeMapping">
        <str name="valueClass">java.lang.Boolean</str>
        <str name="fieldType">booleans</str>
      </lst>
	  ...
    </processor>
	
	-- ================================================
	-- (4) Reload Core {if required}
	-- ================================================
	Reload the core at the URL "http://localhost:8983/solr" in the Cores tab
	
