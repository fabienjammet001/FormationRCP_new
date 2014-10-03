package com.sogeti.rental.ui.prefs;

import java.util.Map;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.ComboFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sogeti.rental.ui.Palette;
import com.sogeti.rental.ui.RentalUiActivator;
import com.sogeti.rental.ui.views.RentalUIConstants;

public class PalettePreferencePage extends FieldEditorPreferencePage implements
		IWorkbenchPreferencePage, RentalUIConstants {

	public PalettePreferencePage() {
		super(GRID);
		setPreferenceStore(RentalUiActivator.getDefault().getPreferenceStore());
		setDescription("");
	}
	
	@Override
	public void init(IWorkbench workbench) {
		// TODO Auto-generated method stub

	}

	@Override
	protected void createFieldEditors() {
		// TODO Auto-generated method stub
		Map<String, Palette> palettes = RentalUiActivator.getDefault().getPaletteManager();
		String[][] comboValues = new String[palettes.size()][2];
		int i=0;
		for(Palette p : palettes.values())
		{
			comboValues[i][0] = p.getName();
			comboValues[i][1] = p.getId();
			i++;
		}
		addField( new ComboFieldEditor(PREF_PALETTE, "Palette couleur :", comboValues, getFieldEditorParent()));
	}

}
