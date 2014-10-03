package com.sogeti.rental.ui.palette;

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
import com.sogeti.rental.ui.RentalUiActivator;
import com.sogeti.rental.ui.views.RentalUIConstants;

public class DefaultPaletteProvider implements IColorProvider, RentalUIConstants {

	public DefaultPaletteProvider() {
		// TODO Auto-generated constructor stub
	}

	public Color getForeground(Object element) {
		// TODO Auto-generated method stub
		if ( element instanceof Customer)
			return getColor(RentalUiActivator.getDefault().getPreferenceStore().getString(PREF_CUSTOMERS));
		else if (element instanceof RentalObject)
		{
			return getColor(RentalUiActivator.getDefault().getPreferenceStore().getString(PREF_RENTALS_OBJECTS));
		}
		else if (element instanceof RentalAgency)
		{
			return getColor("0,0,0");
		}
		else
		{
			return getColor(RentalUiActivator.getDefault().getPreferenceStore().getString(PREF_RENTALS));
		}
	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
	}
	
	private Color getColor( String rgbKey)
	{
		ColorRegistry colorRegistry = JFaceResources.getColorRegistry();
		Color c = colorRegistry.get(rgbKey);
		if ( c == null)
		{
			colorRegistry.put(rgbKey, StringConverter.asRGB(rgbKey));
			c = colorRegistry.get(rgbKey);
		}
		return c;
	}

}
