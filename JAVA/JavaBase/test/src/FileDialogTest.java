import java.awt.Button;
import java.awt.FileDialog;
import java.awt.Frame;
import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class FileDialogTest {

	public static void main(String[] args) {
		Dlg d = new Dlg("FileDialogTest");
	}

}

class Dlg extends Frame {
	Frame fe;
	Button bt1 = new Button("�˳�"), 
			bt2 = new Button("���ļ�"),
			bt3 = new Button("�����ļ�");
	
	public Dlg(String str) {
		super(str);
		fe = this;
		this.setLayout(new GridLayout(3,1));
		this.add(bt1);
		this.add(bt2);
		this.add(bt3);
		pack();
		
		bt1.addActionListener(new ActionListenerC());
		bt2.addActionListener(new ActionListenerC());
		bt3.addActionListener(new ActionListenerC());
		
		this.setVisible(true);
		this.addWindowListener(new WindowAdapter() {
			@Override
			public void windowClosing(WindowEvent arg0) {
				System.exit(0);
			}
			
		});
	}
	
	class ActionListenerC implements ActionListener{
		@Override
		public void actionPerformed(ActionEvent e) {
			if(e.getSource() == bt1){
				dispose();
				System.exit(0);
			} else if(e.getSource() == bt2){
				FileDialog fd1 = new FileDialog(fe, "��ѡ���", FileDialog.LOAD);
				fd1.setVisible(true);
			} else if(e.getSource() == bt3){
				FileDialog fd2 = new FileDialog(fe, "�����뱣��", FileDialog.SAVE);
				fd2.setVisible(true);
			}
		}
		
	}
}