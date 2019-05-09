package SWEA;

import java.io.BufferedReader;
import java.io.InputStreamReader;
import java.util.Arrays;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

public class Line3 {
	
	public static void main(String[] args) throws Exception{
		BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
		Map<Integer,String> map1=new HashMap<Integer,String>();
		String []col=new String[2];
		String [] res = null;
		int idx=0;
		for(int t=0;t<2;t++){
			int rnum=Integer.parseInt(br.readLine());
			String c=br.readLine();
			col[t]=c.substring(3,c.length());
			if(t==0){
				res=new String[rnum-1];
				for(int i=0;i<rnum-1;i++){
					String []temp=br.readLine().split(" ");
					int key=Integer.parseInt(temp[0]);
					String val="";
					for(int k=1;k<temp.length;k++){
						val+=" "+temp[k];
					}
					map1.put(key, val);
				}
			}
			else{
				for(int i=0;i<rnum-1;i++){
					String []temp=br.readLine().split(" ");
					int key=Integer.parseInt(temp[0]);
					String val="";
					for(int k=1;k<temp.length;k++){
						val+=" "+temp[k];
					}
					if(map1.containsKey(key)){
						res[idx]=key+map1.get(key)+val;
						map1.remove(key);
						idx++;
					}
				}
			}
		}
		Set<Integer> tp=map1.keySet();
		if(tp!=null){
			Iterator<Integer> it=tp.iterator();
			while(it.hasNext()){
				int n=it.next();
				res[idx]=n+map1.get(n);
				for(int j=0;j<col[1].split(" ").length;j++){
					res[idx]+=" NULL";
				}
				idx++;
			}
		}
		Arrays.sort(res);
		System.out.println("id "+col[0]+" "+col[1]);
		for(String a:res)
			System.out.println(a);
	}

}
