package com.sogeti.examples.commands.ui;

import java.util.Map;
import java.util.concurrent.ExecutionException;

import org.eclipse.core.commands.AbstractHandler;
import org.eclipse.core.commands.ExecutionEvent;
import org.eclipse.core.commands.IHandler;
import org.eclipse.jface.viewers.ISelection;
import org.eclipse.jface.viewers.IStructuredSelection;
import org.eclipse.swt.dnd.Clipboard;
import org.eclipse.swt.dnd.DND;
import org.eclipse.swt.dnd.RTFTransfer;
import org.eclipse.swt.dnd.TextTransfer;
import org.eclipse.swt.dnd.Transfer;
import org.eclipse.swt.widgets.Display;
import org.eclipse.ui.handlers.HandlerUtil;

import com.opcoach.training.rental.Customer;

public class CopyRentalCustomerHandler extends AbstractHandler implements
		IHandler {

	public Object execute(Map parameterValuesByName) throws ExecutionException {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Object execute(ExecutionEvent event)
			throws org.eclipse.core.commands.ExecutionException {
		ISelection currentSelection = HandlerUtil.getCurrentSelection(event);
		if (currentSelection instanceof IStructuredSelection) {
			IStructuredSelection isel = (IStructuredSelection) currentSelection;

			Object o = isel.getFirstElement();
			if (o instanceof Customer) {
				Customer c = (Customer) o;
				Clipboard clipboard = new Clipboard(Display.getCurrent());
				String textData = c.getDisplayName();
				String rtfData = "{\\rtf1\\b\\i " + textData + "}";
				TextTransfer textTransfer = TextTransfer.getInstance();
				RTFTransfer rtfTransfer = RTFTransfer.getInstance();
				Transfer[] transfers = new Transfer[] { textTransfer,
						rtfTransfer };
				Object[] data = new Object[] { textData, rtfData };
				clipboard.setContents(data, transfers, DND.CLIPBOARD);
				clipboard.dispose();
			}
		}

		return null;

	}

}
