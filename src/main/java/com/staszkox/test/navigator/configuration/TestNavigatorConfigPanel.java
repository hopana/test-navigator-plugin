package com.staszkox.test.navigator.configuration;

import com.intellij.uiDesigner.core.GridConstraints;
import com.intellij.uiDesigner.core.GridLayoutManager;
import com.intellij.uiDesigner.core.Spacer;
import com.intellij.util.ui.JBUI;

import javax.swing.*;
import java.awt.*;

class TestNavigatorConfigPanel {
	private JPanel panel;
	private JTextField prefixesOrSuffixesTextField;

	TestNavigatorConfigPanel(String actualSuffixes) {
		setUp(actualSuffixes);
	}

	private void setUp(String actualSuffixes) {
		panel = new JPanel(new GridLayoutManager(3, 2, JBUI.emptyInsets(), -1, -1));
		panel.setRequestFocusEnabled(true);

		final JLabel prefixesOrSuffixesLabel = new JLabel("Test class prefixes or suffixes:");
		panel.add(prefixesOrSuffixesLabel, new GridConstraints(0, 0, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, new Dimension(80, 16), null, 0, false));

		prefixesOrSuffixesTextField = new JTextField();
		prefixesOrSuffixesTextField.setAutoscrolls(true);
		prefixesOrSuffixesTextField.setEditable(true);
		prefixesOrSuffixesTextField.setEnabled(true);
		prefixesOrSuffixesTextField.setHorizontalAlignment(10);
		prefixesOrSuffixesTextField.setText(actualSuffixes);
		panel.add(prefixesOrSuffixesTextField, new GridConstraints(0, 1, 1, 1, GridConstraints.ANCHOR_NORTH, GridConstraints.FILL_HORIZONTAL, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_WANT_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

		final JLabel fieldDescription = new JLabel();
		fieldDescription.setText("Delimit possible test class suffixes with comma (e.g. \"Test,TestLong,IT\").");
		fieldDescription.setVerticalAlignment(SwingConstants.CENTER);
		panel.add(fieldDescription, new GridConstraints(1, 1, 1, 1, GridConstraints.ANCHOR_NORTHWEST, GridConstraints.FILL_NONE, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, GridConstraints.SIZEPOLICY_CAN_SHRINK | GridConstraints.SIZEPOLICY_CAN_GROW, null, null, null, 0, false));

		final Spacer spacer1 = new Spacer();
		panel.add(spacer1, new GridConstraints(2, 0, 1, 1, GridConstraints.ANCHOR_CENTER, GridConstraints.FILL_VERTICAL, 1, GridConstraints.SIZEPOLICY_WANT_GROW, null, null, null, 0, false));
		prefixesOrSuffixesLabel.setLabelFor(prefixesOrSuffixesTextField);
	}

	JPanel getPanel() {
		return panel;
	}

	String getPrefixesOrSuffixes() {
		return prefixesOrSuffixesTextField.getText();
	}

	void setPrefixesOrSuffixes(String suffixes) {
		prefixesOrSuffixesTextField.setText(suffixes);
	}
}
