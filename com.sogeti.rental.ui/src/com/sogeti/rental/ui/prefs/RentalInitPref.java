package com.sogeti.rental.ui.prefs;

import org.eclipse.core.runtime.preferences.AbstractPreferenceInitializer;
import org.eclipse.jface.preference.IPreferenceStore;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.graphics.RGB;
import org.eclipse.swt.widgets.Display;

import com.sogeti.rental.ui.RentalUiActivator;
import com.sogeti.rental.ui.views.RentalUIConstants;

public class RentalInitPref extends AbstractPreferenceInitializer implements RentalUIConstants  {

	public RentalInitPref() {
		// TODO Auto-generated constructor stub
	}

	@Override
	public void initializeDefaultPreferences() {
		IPreferenceStore ps = RentalUiActivator.getDefault().getPreferenceStore();
		Color c = Display.getCurrent().getSystemColor(SWT.COLOR_BLUE);
		ps.setDefault(PREF_CUSTOMERS, StringConverter.asString(c.getRGB()));
		ps.setDefault(PREF_RENTALS, StringConverter.asString(new RGB(255,125,17)));
		ps.setDefault(PREF_RENTALS_OBJECTS, StringConverter.asString(new RGB(255,255,0)));
		
		

	}

}
