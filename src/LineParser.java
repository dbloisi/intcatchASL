package hello.world.app;

public class LineParser {
    private String line;
    int ts;
    String p;
    String q;
    String zone;
    double p_x;
    double p_y;
    
    public LineParser() {
        
    }
    
    public boolean parse(String line) {        
        this.line = line;
        
        //TODO
        
        return true;
    }
    
    public boolean parseZone(String line, String z) {        
        this.line = line;
        
        int idx1 = line.indexOf("I");
        String timestamp = line.substring(0, idx1);
        timestamp = timestamp.trim();
        //System.out.println(timestamp);
        ts = Integer.parseInt(timestamp);
        //System.out.println(ts);
        
        if(line.contains("pose")) {
            int idx2 = line.indexOf("pose");
            String pose = line.substring(idx2+6);
            //System.out.println("pose: " + pose);
            int idx3 = pose.indexOf("p");
            int idx4 = pose.indexOf("q");
            int idx5 = pose.indexOf("zone");
            p = pose.substring(idx3+3,idx4-2);
            //System.out.println("p: " + p);
            q = pose.substring(idx4+3,idx5-2);
            //System.out.println("q: " + q);
            String zone_temp = pose.substring(idx5+7);
            int idx6 = zone_temp.indexOf("\"");
            zone = zone_temp.substring(0,idx6);
            //System.out.println("zone: " + zone);
            if(zone.equals(z)) {
                int idx7 = p.indexOf(",");
                p_x = Double.parseDouble(p.substring(1,idx7));
                String temp = p.substring(idx7+1);
                //System.out.println("p_x: " + p_x);
                int idx8 = temp.indexOf(",");
                p_y = Double.parseDouble(temp.substring(0,idx8));
                //System.out.println("p_y: " + p_y);
                return true;
            }
        }
        return false;
    }

    public int getTimestamp() {
        return ts;
    }
    
    public double getPx() {
        return p_x;
    }
    
    public double getPy() {
        return p_y;
    }
}

