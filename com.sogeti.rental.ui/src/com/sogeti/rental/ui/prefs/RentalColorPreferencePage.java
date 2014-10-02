package com.sogeti.rental.ui.prefs;

import org.eclipse.jface.preference.ColorFieldEditor;
import org.eclipse.jface.preference.DirectoryFieldEditor;
import org.eclipse.jface.preference.FieldEditorPreferencePage;
import org.eclipse.jface.resource.ImageDescriptor;
import org.eclipse.ui.IWorkbench;
import org.eclipse.ui.IWorkbenchPreferencePage;

import com.sogeti.rental.ui.RentalUiActivator;
import com.sogeti.rental.ui.views.RentalUIConstants;

public class RentalColorPreferencePage extends FieldEditorPreferencePage
		implements IWorkbenchPreferencePage, RentalUIConstants {

	public RentalColorPreferencePage() {
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
		addField( new ColorFieldEditor(PREF_CUSTOMERS, PREF_CUSTOMERS, getFieldEditorParent()));
		addField( new ColorFieldEditor(PREF_RENTALS, PREF_RENTALS, getFieldEditorParent()));
		addField( new ColorFieldEditor(PREF_RENTALS_OBJECTS, PREF_RENTALS_OBJECTS, getFieldEditorParent()));

	}

}
