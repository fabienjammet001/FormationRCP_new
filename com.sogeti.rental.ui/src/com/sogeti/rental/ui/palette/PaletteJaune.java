package com.sogeti.rental.ui.palette;

import java.util.Map;

import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sogeti.rental.ui.Palette;
import com.sogeti.rental.ui.RentalUiActivator;
import com.sogeti.rental.ui.views.RentalUIConstants;

public class PaletteJaune implements IColorProvider, RentalUIConstants {

	public PaletteJaune() {
		// TODO Auto-generated constructor stub
	}
	public Color getForeground(Object element) {
		// TODO Auto-generated method stub
		return Display.getCurrent().getSystemColor(SWT.COLOR_DARK_YELLOW);
	}

	@Override
	public Color getBackground(Object element) {
		return null;
	}
	

}
