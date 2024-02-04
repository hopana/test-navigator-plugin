package com.staszkox.test.navigator.icons;

import com.intellij.codeInsight.navigation.NavigationGutterIconBuilder;
import com.intellij.psi.PsiElement;

import javax.swing.*;

public enum NavigationIconsBuilder {
    TEST_CLASS_AVAILABLE(NavigationIcons.TEST_CLASS_AVAILABLE, "Navigate to test class"),
    TEST_CLASS_NOT_AVAILABLE(NavigationIcons.TEST_CLASS_NOT_AVAILABLE, "Missing test class or located in another package"),
    TEST_CLASS_HAS_NO_TESTS(NavigationIcons.NO_TESTS_IN_TEST_CLASS, "Test class has no tests or tests not recognized"),
    SOURCE_CLASS_AVAILABLE(NavigationIcons.SOURCE_CLASS_AVAILABLE, "Navigate to source class"),
    SOURCE_CLASS_NOT_AVAILABLE(NavigationIcons.SOURCE_CLASS_NOT_AVAILABLE, "Missing source class or located in another package");

    private final Icon icon;
    private final String tooltipText;

    NavigationIconsBuilder(Icon icon, String tooltipText) {
        this.icon = icon;
        this.tooltipText = tooltipText;
    }

    public NavigationGutterIconBuilder<PsiElement> forTarget(PsiElement target) {
        return NavigationGutterIconBuilder.create(icon)
                .setTooltipText(tooltipText)
                .setTargets(target);
    }
}
