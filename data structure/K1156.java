package dataStructure;
import dataStructure.linearList.SqList;
//import dataStructure.linearList.LinkList;

class K1156{
	public static void main(String args[]) throws Exception {
		SqList<TravelCity> l = new SqList(20);
		//LinkList<TravelCity> l = new LinkList();

		TravelCity shanghai = new TravelCity("上海",0);
		l.insert(0,shanghai);
		TravelCity kunshan = new TravelCity("昆山",49);
		l.insert(1,kunshan);
		TravelCity suzhou = new TravelCity("苏州",84);
		l.insert(2,suzhou);
		TravelCity wuxi = new TravelCity("无锡",126);
		l.insert(3,wuxi);
		TravelCity changzhou = new TravelCity("常州",165);
		l.insert(4,changzhou);
		TravelCity danyang = new TravelCity("丹阳",209);
		l.insert(5,danyang);
		TravelCity zhenjiang = new TravelCity("镇江",237);
		l.insert(6,zhenjiang);
		TravelCity nanjing = new TravelCity("南京",301);
		l.insert(7,nanjing);
		TravelCity hefei = new TravelCity("合肥",457);
		l.insert(8,hefei);
		TravelCity hankou = new TravelCity("汉口",821);
		l.insert(9,hankou);
		TravelCity suizhou = new TravelCity("随州",987);
		l.insert(10,suizhou);
		TravelCity xiangyang = new TravelCity("襄阳",1130);
		l.insert(11,xiangyang);
		TravelCity shiyan = new TravelCity("十堰",1301);
		l.insert(12,shiyan);
		TravelCity ankang = new TravelCity("安康",1503);
		l.insert(13,ankang);
		TravelCity wanyuan = new TravelCity("万源",1654);
		l.insert(14,wanyuan);
		TravelCity dazhou = new TravelCity("达州",1779);
		l.insert(15,dazhou);
		TravelCity nanchong = new TravelCity("南充",1938);
		l.insert(16,nanchong);
		TravelCity chengdu = new TravelCity("成都",2153);
		l.insert(17,chengdu);
		
		l.display();
		
		System.out.println(shiyan.getName()+" 距离 "+chengdu.getName()+"  "+chengdu.distance(shiyan)+"公里");
		System.out.println(shiyan.getName()+" 是K1156列车的第 "+l.indexOf(shiyan)+"站");
	}
}