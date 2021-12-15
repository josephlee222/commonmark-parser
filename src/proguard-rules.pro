# Add any ProGuard configurations specific to this
# extension here.

-keep public class com.memelabs.commonmarkparser.CommonmarkParser {
    public *;
 }
-keeppackagenames gnu.kawa**, gnu.expr**

-optimizationpasses 4
-allowaccessmodification
-mergeinterfacesaggressively

-repackageclasses 'com/memelabs/commonmarkparser/repack'
-flattenpackagehierarchy
-dontpreverify
