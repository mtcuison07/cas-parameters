
import org.guanzon.appdriver.base.GRider;
import org.guanzon.appdriver.base.MiscUtil;
import org.guanzon.cas.parameters.Relationship;
import org.json.simple.JSONObject;
import org.junit.AfterClass;
import org.junit.Assert;
import org.junit.BeforeClass;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class testRelationship {
    static GRider instance;
    static Relationship record;
    
    @BeforeClass
    public static void setUpClass(){
        System.setProperty("sys.default.path.metadata", "D:/GGC_Maven_Systems/config/metadata/");
        
        instance = MiscUtil.Connect();
        record = new Relationship(instance, false);
    }
    
   
    
    @Test
    public void testProgramFlow(){
        JSONObject loJSON;
        
        loJSON = record.newRecord();
        if ("error".equals((String) loJSON.get("result"))) Assert.fail((String) loJSON.get("message"));
        
        loJSON = record.getModel().setRelatnDs("Single");
        if ("error".equals((String) loJSON.get("result"))) Assert.fail((String) loJSON.get("message"));
        
        loJSON = record.getModel().setModifiedBy(instance.getUserID());
        if ("error".equals((String) loJSON.get("result"))) Assert.fail((String) loJSON.get("message"));
        
        loJSON = record.getModel().setModifiedDate(instance.getServerDate());
        if ("error".equals((String) loJSON.get("result"))) Assert.fail((String) loJSON.get("message"));
        
        loJSON = record.saveRecord();
        if ("error".equals((String) loJSON.get("result"))) Assert.fail((String) loJSON.get("message"));
    }
    
     @AfterClass
    public static void tearDownClass() {
        record = null;
        instance = null;
    }
}
