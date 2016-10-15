package TestaInte;

public class Ls {

	private Directory d;

	public Ls(Directory d) {
		this.d = d;
	}

	public void execute() {
		for(FSO fso: d.listContent()){
			System.out.println(fso);
		}
	}

}
