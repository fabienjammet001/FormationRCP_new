package com.sogeti.rental.ui.palette;

import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

public class PaletteBleue implements IColorProvider {

	public PaletteBleue() {
		// TODO Auto-generated constructor stub
	}

	public Color getForeground(Object element) {
		// TODO Auto-generated method stub
		return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_BLUE);
	}
	
	@Override
	public Color getBackground(Object element) {
		return null;
	}


}
