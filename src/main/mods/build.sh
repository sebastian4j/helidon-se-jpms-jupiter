#!/bin/bash
cd target
echo "buscando modulos"
JAVA_BASE_MODS=$(find . -name "*.jar" -exec jdeps --module-path libs:*.jar -s {} \; | sed -En "s/.* -> (java.*)/ \1;/p" | sort | uniq | grep -v "java.annotation" | tr -s ';\n ' ',')
echo "construir jre"
${JAVA_HOME}/bin/jlink --module-path "${JAVA_HOME}/jmods:libs:*.jar" \
    --add-modules java.management,jdk.unsupported"${JAVA_BASE_MODS}" \
    --strip-debug --compress 2 --no-man-pages \
    --no-header-files --output jre
echo "construir imagen docker"
docker build -t ${project.artifactId}:latest .
