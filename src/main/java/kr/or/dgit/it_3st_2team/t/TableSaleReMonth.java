package kr.or.dgit.it_3st_2team.t;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.swing.JTextField;
import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_2team.dto.Sale;
import kr.or.dgit.it_3st_2team.service.SaleService;
import kr.or.dgit.it_3st_2team.ui.ReportSaleJPanel;

public class TableSaleReMonth extends AbstractTable<Sale> {
	private SaleService sservice = new SaleService();
	private ReportSaleJPanel resaleframe;
	
	
	public TableSaleReMonth() {
	}
	public TableSaleReMonth(ReportSaleJPanel reportSaleFrame) {
		this.resaleframe=reportSaleFrame;
	}
	
	
	@Override
	public void setAlignWidth() {
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2, 3, 4, 5, 6);
		tableCellAlign(SwingConstants.RIGHT, 6);
		tableCellWidth(100, 200, 150, 150, 300, 150, 200);
	}

	@Override
	public String[] getColumNames() {
		return new String[] { "영업 번호", "영업 일자", "영업시간", "고객명", "헤어명", "이벤트명", "가격" };
	}

	@Override
	public Object[][] getRows(List<Sale> list) {
		Map<String,Object> map = new HashMap<>();	
		JTextField  re= resaleframe.getTfDate();
		String s=re.getText();
		map.put("sDate","%-"+s+"-%");
		List<Integer> count = sservice.selectCountMonth(map);
		Object[][] rows = null;
		int countindex = 0;
		int tcount = 0;
		int sum = 0;
		int toTalcount=0;
		int toTalSum=0;
		Date year =new Date();
		rows = new Object[list.size()+count.size()+1][];
		int listindex=0;
		for(int i=0; i<rows.length-1;){		
			rows[i] = list.get(listindex).toArrayMonth(); 
			sum+= list.get(listindex).getsPrice();
			year = list.get(listindex).getsDate();
			SimpleDateFormat sdf = new SimpleDateFormat("yyyy");
			listindex++;
			tcount++;
			 i++;
			if (tcount == count.get(countindex)) {			
				rows[i++] = new Object[] {"",sdf.format(year)+"년 "+s+"월 합계","","","",tcount+"건",toString().format("%,3d", sum)};			
				toTalcount+=tcount;
				toTalSum+=sum;
				countindex++;
				tcount = 0;
				sum=0;
			}
		}	
		rows[rows.length-1] = new Object[] {"","","","","총계",toTalcount+"건",toString().format("%,3d", toTalSum)};
		return rows;
	}

}
