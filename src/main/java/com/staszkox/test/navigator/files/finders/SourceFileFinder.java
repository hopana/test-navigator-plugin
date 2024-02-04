package com.staszkox.test.navigator.files.finders;

import com.intellij.psi.PsiClass;
import com.staszkox.test.navigator.configuration.TestNavigatorConfig;
import org.apache.commons.lang3.StringUtils;

import java.util.Collections;
import java.util.List;
import java.util.stream.Collectors;

/**
 * 通过测试类找对应的源文件类
 */
public class SourceFileFinder extends FileFinder {

    public static SourceFileFinder forClass(PsiClass testClass) {
        return new SourceFileFinder(testClass);
    }

    private SourceFileFinder(PsiClass testClass) {
        super(testClass);
    }

    /**
     * 通过类名和配置的前缀/后缀，搜索与之匹配的测试类名
     * 如原文件：Person.class，配置的前缀/后缀为["Test", "Foo"]，则搜索的文件名为：[PersonTest.class, TestPerson.class, PersonFoo.class, FooPerson.class]
     * 因此，返回列表为：[PersonTest.class, TestPerson.class, PersonFoo.class, FooPerson.class]
     */
    @Override
    protected List<String> getFileNamesForSearch() {
        TestNavigatorConfig configuration = TestNavigatorConfig.getInstance();
        List<String> prefixesOrSuffixes = configuration != null ? configuration.getPrefixesOrSuffixes() : Collections.emptyList();

        // fixme 全限定名代包名，但是不带后缀：com.example.package.ClassName
        String qualifiedClassName = getBaseClass().getQualifiedName();
        if (StringUtils.isBlank(qualifiedClassName)) {
            return Collections.emptyList();
        }

        return prefixesOrSuffixes.stream()
                // 注意，replace不改变原字符串
                .map(prefixOrSuffix -> qualifiedClassName.replace(prefixOrSuffix, ""))
                .filter(fileForSearch -> !qualifiedClassName.equals(fileForSearch))
                .collect(Collectors.toList());
    }

}
