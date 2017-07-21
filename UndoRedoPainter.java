package stacklab;

import java.util.*;


public class UndoRedoPainter extends Painter
{
	// Called when the user pushes the Undo button.
	
	public UndoRedoPainter() {
		setUndoButtonEnabled(false);
		setRedoButtonEnabled(false);
	}
	
	@Override
	void undo()
	{
		Stack<Circle> newHistory = getHistory(); 
		if(newHistory.isEmpty()) {
			setUndoButtonEnabled(false);
			return;
		}
		Circle c = newHistory.pop(); 
		getUndoHistory().push(c);
		repaint();
		setUndoButtonEnabled(true);
		setRedoButtonEnabled(true);
		
	}


	// Called when the user pushes the Redo button.
	void redo()
	{
		Stack<Circle> backHistory = getUndoHistory();
		if(backHistory.isEmpty()) {
			setRedoButtonEnabled(false);
			return;
		}
		Circle cr = backHistory.pop(); 
		getHistory().push(cr);
		repaint();
	}
	
	
	public static void main(String[] args)
	{
		new UndoRedoPainter().setVisible(true);
	}
}
