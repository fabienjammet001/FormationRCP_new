package com.sogeti.rental.ui.views;

import java.awt.Image;
import java.io.ObjectInputStream.GetField;
import java.util.Collection;
import java.util.Map;

import org.eclipse.jface.resource.ColorRegistry;
import org.eclipse.jface.resource.JFaceResources;
import org.eclipse.jface.resource.StringConverter;
import org.eclipse.jface.viewers.IColorProvider;
import org.eclipse.jface.viewers.ITreeContentProvider;
import org.eclipse.jface.viewers.LabelProvider;
import org.eclipse.jface.viewers.Viewer;
import org.eclipse.swt.SWT;
import org.eclipse.swt.graphics.Color;
import org.eclipse.swt.widgets.Display;

import com.opcoach.training.rental.Customer;
import com.opcoach.training.rental.Rental;
import com.opcoach.training.rental.RentalAgency;
import com.opcoach.training.rental.RentalObject;
import com.sogeti.rental.ui.Palette;
import com.sogeti.rental.ui.RentalUiActivator;

public class RentalProvider extends LabelProvider implements
		ITreeContentProvider, RentalUIConstants, IColorProvider {

	private static final Object[] EMPTY_RESULT = new Object[0];

	@Override
	public void inputChanged(Viewer viewer, Object oldInput, Object newInput) {
		// TODO Auto-generated method stub

	}

	@Override
	public Object[] getElements(Object inputElement) {
		// TODO Auto-generated method stub
		Object[] result = null;
		if (inputElement instanceof Collection<?>)
		{
			result = ((Collection<?>) inputElement).toArray();
		}
		return ( result == null ) ? EMPTY_RESULT  : result;
	}

	@Override
	public Object[] getChildren(Object parentElement) {
		// TODO Auto-generated method stub
		if ( parentElement instanceof RentalAgency )
		{
			RentalAgency ra= (RentalAgency) parentElement;
			return new Node[]{ new Node(CUSTOMERS_NODE, ra), new Node(OBJECTS_NODE, ra), new Node(RENTALS_NODE, ra) };
		}
		else if ( parentElement instanceof Node)
		{
			return ((Node) parentElement).getChildren();
		}
		return null;
		
	}

	@Override
	public Object getParent(Object element) {
		// TODO Auto-generated method stub
		
		return EMPTY_RESULT;
	}

	@Override
	public boolean hasChildren(Object element) {
		// TODO Auto-generated method stub
		//RentalAgency ra= (RentalAgency) element;
		return true;
	}
	@Override
	public String getText(Object element) {
		if (element instanceof RentalAgency)
			return ((RentalAgency) element).getName();
		else if ( element instanceof Customer)
			return ((Customer) element).getDisplayName();
		else if ( element instanceof RentalObject)
			return ((RentalObject) element).getName();		
		else			
			return super.getText(element);
	}
	public class Node {
		private String label = "";
		private RentalAgency a;
		
		@Override
		public int hashCode() {
			final int prime = 31;
			int result = 1;
			result = prime * result + getOuterType().hashCode();
			result = prime * result + ((a == null) ? 0 : a.hashCode());
			result = prime * result + ((label == null) ? 0 : label.hashCode());
			return result;
		}
		@Override
		public boolean equals(Object obj) {
			if (this == obj)
				return true;
			if (obj == null)
				return false;
			if (getClass() != obj.getClass())
				return false;
			Node other = (Node) obj;
			if (!getOuterType().equals(other.getOuterType()))
				return false;
			if (a == null) {
				if (other.a != null)
					return false;
			} else if (!a.equals(other.a))
				return false;
			if (label == null) {
				if (other.label != null)
					return false;
			} else if (!label.equals(other.label))
				return false;
			return true;
		}
		public Node(String label, RentalAgency a) {
			super();
			this.label = label;
			this.a = a;
		}
		private String getLabel() {
			return label;
		}
		private void setLabel(String label) {
			this.label = label;
		}
		private RentalAgency getA() {
			return a;
		}
		private void setA(RentalAgency a) {
			this.a = a;
		}
		private Object[] getChildren()
		{
			if (label  == CUSTOMERS_NODE)
			{
				return a.getCustomers().toArray();
			}
			else if (label  ==  OBJECTS_NODE )
			{
				return a.getObjectsToRent().toArray();
			}
			else if ( label  == RENTALS_NODE)
				return a.getRentals().toArray();
			else
				return EMPTY_RESULT;
		}
		@Override
		public String toString() {
			// TODO Auto-generated method stub
			return label;
		}
		private RentalProvider getOuterType() {
			return RentalProvider.this;
		}
	}
	@Override
	public Color getForeground(Object element) {
		String id_p = RentalUiActivator.getDefault().getPreferenceStore().getString(PREF_PALETTE);
		Map<String, Palette> palettes = RentalUiActivator.getDefault().getPaletteManager();
		Palette p = palettes.get(id_p);
		
		
		return p.getProvider().getForeground(element);

	}

	@Override
	public Color getBackground(Object element) {
		// TODO Auto-generated method stub
		return Display.getCurrent().getSystemColor(SWT.COLOR_WHITE);
	}
	public org.eclipse.swt.graphics.Image getImage(Object element)
	{
		if (element instanceof RentalAgency)
			return RentalUiActivator.getDefault().getImageRegistry().get(ICONS_AGENCY);
		else if ( element instanceof Customer)
			return RentalUiActivator.getDefault().getImageRegistry().get(ICONS_CUSTOMERS);
		else if ( element instanceof RentalObject)
			return RentalUiActivator.getDefault().getImageRegistry().get(ICONS_RENTALS_OBJECTS);
		else if ( element instanceof Rental)
			return RentalUiActivator.getDefault().getImageRegistry().get(ICONS_RENTALS);		
		else			
			return null;	
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



