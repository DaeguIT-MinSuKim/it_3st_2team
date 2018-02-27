package kr.or.dgit.it_3st_2team.t;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

import javax.swing.SwingConstants;

import kr.or.dgit.it_3st_2team.dto.Sale;

public class TableSaleRe extends AbstractTable<Sale> {
	public TableSaleRe() {
	}

	@Override
	public void setAlignWidth() {
		tableCellAlign(SwingConstants.CENTER, 0, 1, 2,3,4,5);
		tableCellWidth(100, 200, 100,300,300,300);
	}

	@Override
	public String[] getColumNames() {
		return new String[] {"영업 번호", "영업 일자", "영업시간","고객명","헤어명","이벤트명"};
	}

	@Override
	public Object[][] getRows(List<Sale> list) {
		Object[][] rows = null;

		/*rows = new Object[list.size()][];
		for(int i=0; i<list.size(); i++) {
			rows[i] = list.get(i).toArrayMonth();
		}*/
		
		rows = new Object[list.size()][];
		for(int i=0; i<list.size(); i++) {
			rows[i] = list.get(i).toArrayMonth();
			Date d = list.get(i).getsDate();
			SimpleDateFormat sdf = new SimpleDateFormat("MM");
			sdf.format(d);
			System.out.println(sdf);
		}
/*		rows = new Object[list.size()][];
		for(int i=0; i<list.size(); i++) {
			
			for(int j=0;j<list.size();j++) {
				rows[j] = list.get(j).toArrayMonth();
			}
			rows[i] = list.get(i).toArrayMonthTotal();
		}
*/
		return rows;
	}

}
