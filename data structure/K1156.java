package dataStructure;
import dataStructure.linearList.SqList;
//import dataStructure.linearList.LinkList;

class K1156{
	public static void main(String args[]) throws Exception {
		SqList<TravelCity> l = new SqList(20);
		//LinkList<TravelCity> l = new LinkList();

		TravelCity shanghai = new TravelCity("�Ϻ�",0);
		l.insert(0,shanghai);
		TravelCity kunshan = new TravelCity("��ɽ",49);
		l.insert(1,kunshan);
		TravelCity suzhou = new TravelCity("����",84);
		l.insert(2,suzhou);
		TravelCity wuxi = new TravelCity("����",126);
		l.insert(3,wuxi);
		TravelCity changzhou = new TravelCity("����",165);
		l.insert(4,changzhou);
		TravelCity danyang = new TravelCity("����",209);
		l.insert(5,danyang);
		TravelCity zhenjiang = new TravelCity("��",237);
		l.insert(6,zhenjiang);
		TravelCity nanjing = new TravelCity("�Ͼ�",301);
		l.insert(7,nanjing);
		TravelCity hefei = new TravelCity("�Ϸ�",457);
		l.insert(8,hefei);
		TravelCity hankou = new TravelCity("����",821);
		l.insert(9,hankou);
		TravelCity suizhou = new TravelCity("����",987);
		l.insert(10,suizhou);
		TravelCity xiangyang = new TravelCity("����",1130);
		l.insert(11,xiangyang);
		TravelCity shiyan = new TravelCity("ʮ��",1301);
		l.insert(12,shiyan);
		TravelCity ankang = new TravelCity("����",1503);
		l.insert(13,ankang);
		TravelCity wanyuan = new TravelCity("��Դ",1654);
		l.insert(14,wanyuan);
		TravelCity dazhou = new TravelCity("����",1779);
		l.insert(15,dazhou);
		TravelCity nanchong = new TravelCity("�ϳ�",1938);
		l.insert(16,nanchong);
		TravelCity chengdu = new TravelCity("�ɶ�",2153);
		l.insert(17,chengdu);
		
		l.display();
		
		System.out.println(shiyan.getName()+" ���� "+chengdu.getName()+"  "+chengdu.distance(shiyan)+"����");
		System.out.println(shiyan.getName()+" ��K1156�г��ĵ� "+l.indexOf(shiyan)+"վ");
	}
}