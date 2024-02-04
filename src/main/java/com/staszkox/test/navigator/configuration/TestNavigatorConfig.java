package com.staszkox.test.navigator.configuration;

import com.google.common.collect.Lists;
import com.intellij.openapi.components.PersistentStateComponent;
import com.intellij.openapi.components.ServiceManager;
import com.intellij.openapi.components.State;
import com.intellij.openapi.components.Storage;
import com.intellij.util.xmlb.XmlSerializerUtil;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

import java.util.List;

@State(name = "TestNavigatorConfig", storages = {@Storage("TestNavigatorConfig.xml")})
public class TestNavigatorConfig implements PersistentStateComponent<TestNavigatorConfig> {
    private static final String DEFAULT_TEST_SUFFIX = "Test";

    private List<String> prefixesOrSuffixes;

    public TestNavigatorConfig() {
        setDefaultTestClassSuffixes();
    }

    @Nullable
    @Override
    public TestNavigatorConfig getState() {
        return this;
    }

    @Override
    public void loadState(@NotNull TestNavigatorConfig testNavigatorConfig) {
        XmlSerializerUtil.copyBean(testNavigatorConfig, this);
    }

    @Nullable
    public static TestNavigatorConfig getInstance() {
        return ServiceManager.getService(TestNavigatorConfig.class);
    }

    public List<String> getPrefixesOrSuffixes() {
        return prefixesOrSuffixes;
    }

    public void setPrefixesOrSuffixes(List<String> prefixesOrSuffixes) {
        this.prefixesOrSuffixes = prefixesOrSuffixes;
    }

    public void setDefaultTestClassSuffixes() {
        this.prefixesOrSuffixes = Lists.newArrayList(DEFAULT_TEST_SUFFIX);
    }
}
