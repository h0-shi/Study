package coll;

import java.util.ArrayList;
import java.util.List;

class Board{
	private int no, like;
	private String title, write, date;
	public Board(int no, String title, String write, String date, int like) {
		this.no = no;
		this.title = title;
		this.write = write;
		this.date = date;
		this.like = like;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}
	public int getLike() {
		return like;
	}
	public void setLike(int like) {
		this.like = like;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getWrite() {
		return write;
	}
	public void setWrite(String write) {
		this.write = write;
	}
	public String getDate() {
		return date;
	}
	public void setDate(String date) {
		this.date = date;
	}
	  
	
}
//번호 | 제목 | 글쓴이 | 날짜 | 좋아요 순서로 출력하도록 해봐
public class List03 {
	public static void main(String[] args) {
		List<Board> list = new ArrayList<Board>();
		Board board = new Board(1,"첫번째 글","박시호","12.22",1);
		list.add(board);

		Board board2 = new Board(2,"두번쨰 글","박기찬","12.23",2);
		list.add(board2);
		
		Board board3 = new Board(3,"세번쨰 글","김동한","12.24",5);
		list.add(board3);
		
		Board board4 = new Board(4,"네번쨰 글","김수민","12.25",7);
		list.add(board4);

		Board board5 = new Board(5,"다섯번쨰 글","김상진","12.26",9);
		list.add(board5);
		
		for (int i = 0; i < list.size(); i++) {
			System.out.print(list.get(i).getNo()+"\t");
			System.out.print(list.get(i).getTitle()+"\t");
			System.out.print(list.get(i).getWrite()+"\t");
			System.out.print(list.get(i).getDate()+"\t");
			System.out.println(list.get(i).getLike());
			
		}
		
	}

}
