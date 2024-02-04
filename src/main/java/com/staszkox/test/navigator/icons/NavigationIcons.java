package com.staszkox.test.navigator.icons;

import com.intellij.openapi.util.IconLoader;

import javax.swing.*;

interface NavigationIcons {
    Icon TEST_CLASS_AVAILABLE = IconLoader.getIcon("/icons/greenTest.png");
    Icon TEST_CLASS_NOT_AVAILABLE = IconLoader.getIcon("/icons/redTest.png");
    Icon NO_TESTS_IN_TEST_CLASS = IconLoader.getIcon("/icons/yellowTest.png");
    Icon SOURCE_CLASS_AVAILABLE = IconLoader.getIcon("/icons/greenSource.png");
    Icon SOURCE_CLASS_NOT_AVAILABLE = IconLoader.getIcon("/icons/redSource.png");
}
