package io.realm;


import android.annotation.TargetApi;
import android.os.Build;
import android.util.JsonReader;
import android.util.JsonToken;
import io.realm.ImportFlag;
import io.realm.ProxyUtils;
import io.realm.exceptions.RealmMigrationNeededException;
import io.realm.internal.ColumnInfo;
import io.realm.internal.OsList;
import io.realm.internal.OsObject;
import io.realm.internal.OsObjectSchemaInfo;
import io.realm.internal.OsSchemaInfo;
import io.realm.internal.Property;
import io.realm.internal.RealmObjectProxy;
import io.realm.internal.Row;
import io.realm.internal.Table;
import io.realm.internal.android.JsonUtils;
import io.realm.internal.objectstore.OsObjectBuilder;
import io.realm.log.RealmLog;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Date;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

@SuppressWarnings("all")
public class jp_techacademy_kenji_takada_taskapp_TaskRealmProxy extends jp.techacademy.kenji.takada.taskapp.Task
    implements RealmObjectProxy, jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface {

    static final class TaskColumnInfo extends ColumnInfo {
        long titleColKey;
        long contentsColKey;
        long dateColKey;
        long idColKey;

        TaskColumnInfo(OsSchemaInfo schemaInfo) {
            super(4);
            OsObjectSchemaInfo objectSchemaInfo = schemaInfo.getObjectSchemaInfo("Task");
            this.titleColKey = addColumnDetails("title", "title", objectSchemaInfo);
            this.contentsColKey = addColumnDetails("contents", "contents", objectSchemaInfo);
            this.dateColKey = addColumnDetails("date", "date", objectSchemaInfo);
            this.idColKey = addColumnDetails("id", "id", objectSchemaInfo);
        }

        TaskColumnInfo(ColumnInfo src, boolean mutable) {
            super(src, mutable);
            copy(src, this);
        }

        @Override
        protected final ColumnInfo copy(boolean mutable) {
            return new TaskColumnInfo(this, mutable);
        }

        @Override
        protected final void copy(ColumnInfo rawSrc, ColumnInfo rawDst) {
            final TaskColumnInfo src = (TaskColumnInfo) rawSrc;
            final TaskColumnInfo dst = (TaskColumnInfo) rawDst;
            dst.titleColKey = src.titleColKey;
            dst.contentsColKey = src.contentsColKey;
            dst.dateColKey = src.dateColKey;
            dst.idColKey = src.idColKey;
        }
    }

    private static final OsObjectSchemaInfo expectedObjectSchemaInfo = createExpectedObjectSchemaInfo();

    private TaskColumnInfo columnInfo;
    private ProxyState<jp.techacademy.kenji.takada.taskapp.Task> proxyState;

    jp_techacademy_kenji_takada_taskapp_TaskRealmProxy() {
        proxyState.setConstructionFinished();
    }

    @Override
    public void realm$injectObjectContext() {
        if (this.proxyState != null) {
            return;
        }
        final BaseRealm.RealmObjectContext context = BaseRealm.objectContext.get();
        this.columnInfo = (TaskColumnInfo) context.getColumnInfo();
        this.proxyState = new ProxyState<jp.techacademy.kenji.takada.taskapp.Task>(this);
        proxyState.setRealm$realm(context.getRealm());
        proxyState.setRow$realm(context.getRow());
        proxyState.setAcceptDefaultValue$realm(context.getAcceptDefaultValue());
        proxyState.setExcludeFields$realm(context.getExcludeFields());
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$title() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.titleColKey);
    }

    @Override
    public void realmSet$title(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'title' to null.");
            }
            row.getTable().setString(columnInfo.titleColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'title' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.titleColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public String realmGet$contents() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.lang.String) proxyState.getRow$realm().getString(columnInfo.contentsColKey);
    }

    @Override
    public void realmSet$contents(String value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'contents' to null.");
            }
            row.getTable().setString(columnInfo.contentsColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'contents' to null.");
        }
        proxyState.getRow$realm().setString(columnInfo.contentsColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public Date realmGet$date() {
        proxyState.getRealm$realm().checkIfValid();
        return (java.util.Date) proxyState.getRow$realm().getDate(columnInfo.dateColKey);
    }

    @Override
    public void realmSet$date(Date value) {
        if (proxyState.isUnderConstruction()) {
            if (!proxyState.getAcceptDefaultValue$realm()) {
                return;
            }
            final Row row = proxyState.getRow$realm();
            if (value == null) {
                throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
            }
            row.getTable().setDate(columnInfo.dateColKey, row.getObjectKey(), value, true);
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        if (value == null) {
            throw new IllegalArgumentException("Trying to set non-nullable field 'date' to null.");
        }
        proxyState.getRow$realm().setDate(columnInfo.dateColKey, value);
    }

    @Override
    @SuppressWarnings("cast")
    public int realmGet$id() {
        proxyState.getRealm$realm().checkIfValid();
        return (int) proxyState.getRow$realm().getLong(columnInfo.idColKey);
    }

    @Override
    public void realmSet$id(int value) {
        if (proxyState.isUnderConstruction()) {
            // default value of the primary key is always ignored.
            return;
        }

        proxyState.getRealm$realm().checkIfValid();
        throw new io.realm.exceptions.RealmException("Primary key field 'id' cannot be changed after object was created.");
    }

    private static OsObjectSchemaInfo createExpectedObjectSchemaInfo() {
        OsObjectSchemaInfo.Builder builder = new OsObjectSchemaInfo.Builder("Task", 4, 0);
        builder.addPersistedProperty("title", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("contents", RealmFieldType.STRING, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("date", RealmFieldType.DATE, !Property.PRIMARY_KEY, !Property.INDEXED, Property.REQUIRED);
        builder.addPersistedProperty("id", RealmFieldType.INTEGER, Property.PRIMARY_KEY, Property.INDEXED, Property.REQUIRED);
        return builder.build();
    }

    public static OsObjectSchemaInfo getExpectedObjectSchemaInfo() {
        return expectedObjectSchemaInfo;
    }

    public static TaskColumnInfo createColumnInfo(OsSchemaInfo schemaInfo) {
        return new TaskColumnInfo(schemaInfo);
    }

    public static String getSimpleClassName() {
        return "Task";
    }

    public static final class ClassNameHelper {
        public static final String INTERNAL_CLASS_NAME = "Task";
    }

    @SuppressWarnings("cast")
    public static jp.techacademy.kenji.takada.taskapp.Task createOrUpdateUsingJsonObject(Realm realm, JSONObject json, boolean update)
        throws JSONException {
        final List<String> excludeFields = Collections.<String> emptyList();
        jp.techacademy.kenji.takada.taskapp.Task obj = null;
        if (update) {
            Table table = realm.getTable(jp.techacademy.kenji.takada.taskapp.Task.class);
            TaskColumnInfo columnInfo = (TaskColumnInfo) realm.getSchema().getColumnInfo(jp.techacademy.kenji.takada.taskapp.Task.class);
            long pkColumnKey = columnInfo.idColKey;
            long colKey = Table.NO_MATCH;
            if (!json.isNull("id")) {
                colKey = table.findFirstLong(pkColumnKey, json.getLong("id"));
            }
            if (colKey != Table.NO_MATCH) {
                final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
                try {
                    objectContext.set(realm, table.getUncheckedRow(colKey), realm.getSchema().getColumnInfo(jp.techacademy.kenji.takada.taskapp.Task.class), false, Collections.<String> emptyList());
                    obj = new io.realm.jp_techacademy_kenji_takada_taskapp_TaskRealmProxy();
                } finally {
                    objectContext.clear();
                }
            }
        }
        if (obj == null) {
            if (json.has("id")) {
                if (json.isNull("id")) {
                    obj = (io.realm.jp_techacademy_kenji_takada_taskapp_TaskRealmProxy) realm.createObjectInternal(jp.techacademy.kenji.takada.taskapp.Task.class, null, true, excludeFields);
                } else {
                    obj = (io.realm.jp_techacademy_kenji_takada_taskapp_TaskRealmProxy) realm.createObjectInternal(jp.techacademy.kenji.takada.taskapp.Task.class, json.getInt("id"), true, excludeFields);
                }
            } else {
                throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
            }
        }

        final jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface objProxy = (jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) obj;
        if (json.has("title")) {
            if (json.isNull("title")) {
                objProxy.realmSet$title(null);
            } else {
                objProxy.realmSet$title((String) json.getString("title"));
            }
        }
        if (json.has("contents")) {
            if (json.isNull("contents")) {
                objProxy.realmSet$contents(null);
            } else {
                objProxy.realmSet$contents((String) json.getString("contents"));
            }
        }
        if (json.has("date")) {
            if (json.isNull("date")) {
                objProxy.realmSet$date(null);
            } else {
                Object timestamp = json.get("date");
                if (timestamp instanceof String) {
                    objProxy.realmSet$date(JsonUtils.stringToDate((String) timestamp));
                } else {
                    objProxy.realmSet$date(new Date(json.getLong("date")));
                }
            }
        }
        return obj;
    }

    @SuppressWarnings("cast")
    @TargetApi(Build.VERSION_CODES.HONEYCOMB)
    public static jp.techacademy.kenji.takada.taskapp.Task createUsingJsonStream(Realm realm, JsonReader reader)
        throws IOException {
        boolean jsonHasPrimaryKey = false;
        final jp.techacademy.kenji.takada.taskapp.Task obj = new jp.techacademy.kenji.takada.taskapp.Task();
        final jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface objProxy = (jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) obj;
        reader.beginObject();
        while (reader.hasNext()) {
            String name = reader.nextName();
            if (false) {
            } else if (name.equals("title")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$title((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$title(null);
                }
            } else if (name.equals("contents")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$contents((String) reader.nextString());
                } else {
                    reader.skipValue();
                    objProxy.realmSet$contents(null);
                }
            } else if (name.equals("date")) {
                if (reader.peek() == JsonToken.NULL) {
                    reader.skipValue();
                    objProxy.realmSet$date(null);
                } else if (reader.peek() == JsonToken.NUMBER) {
                    long timestamp = reader.nextLong();
                    if (timestamp > -1) {
                        objProxy.realmSet$date(new Date(timestamp));
                    }
                } else {
                    objProxy.realmSet$date(JsonUtils.stringToDate(reader.nextString()));
                }
            } else if (name.equals("id")) {
                if (reader.peek() != JsonToken.NULL) {
                    objProxy.realmSet$id((int) reader.nextInt());
                } else {
                    reader.skipValue();
                    throw new IllegalArgumentException("Trying to set non-nullable field 'id' to null.");
                }
                jsonHasPrimaryKey = true;
            } else {
                reader.skipValue();
            }
        }
        reader.endObject();
        if (!jsonHasPrimaryKey) {
            throw new IllegalArgumentException("JSON object doesn't have the primary key field 'id'.");
        }
        return realm.copyToRealm(obj);
    }

    private static jp_techacademy_kenji_takada_taskapp_TaskRealmProxy newProxyInstance(BaseRealm realm, Row row) {
        // Ignore default values to avoid creating unexpected objects from RealmModel/RealmList fields
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        objectContext.set(realm, row, realm.getSchema().getColumnInfo(jp.techacademy.kenji.takada.taskapp.Task.class), false, Collections.<String>emptyList());
        io.realm.jp_techacademy_kenji_takada_taskapp_TaskRealmProxy obj = new io.realm.jp_techacademy_kenji_takada_taskapp_TaskRealmProxy();
        objectContext.clear();
        return obj;
    }

    public static jp.techacademy.kenji.takada.taskapp.Task copyOrUpdate(Realm realm, TaskColumnInfo columnInfo, jp.techacademy.kenji.takada.taskapp.Task object, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null) {
            final BaseRealm otherRealm = ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm();
            if (otherRealm.threadId != realm.threadId) {
                throw new IllegalArgumentException("Objects which belong to Realm instances in other threads cannot be copied into this Realm instance.");
            }
            if (otherRealm.getPath().equals(realm.getPath())) {
                return object;
            }
        }
        final BaseRealm.RealmObjectContext objectContext = BaseRealm.objectContext.get();
        RealmObjectProxy cachedRealmObject = cache.get(object);
        if (cachedRealmObject != null) {
            return (jp.techacademy.kenji.takada.taskapp.Task) cachedRealmObject;
        }

        jp.techacademy.kenji.takada.taskapp.Task realmObject = null;
        boolean canUpdate = update;
        if (canUpdate) {
            Table table = realm.getTable(jp.techacademy.kenji.takada.taskapp.Task.class);
            long pkColumnKey = columnInfo.idColKey;
            long colKey = table.findFirstLong(pkColumnKey, ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id());
            if (colKey == Table.NO_MATCH) {
                canUpdate = false;
            } else {
                try {
                    objectContext.set(realm, table.getUncheckedRow(colKey), columnInfo, false, Collections.<String> emptyList());
                    realmObject = new io.realm.jp_techacademy_kenji_takada_taskapp_TaskRealmProxy();
                    cache.put(object, (RealmObjectProxy) realmObject);
                } finally {
                    objectContext.clear();
                }
            }
        }

        return (canUpdate) ? update(realm, columnInfo, realmObject, object, cache, flags) : copy(realm, columnInfo, object, update, cache, flags);
    }

    public static jp.techacademy.kenji.takada.taskapp.Task copy(Realm realm, TaskColumnInfo columnInfo, jp.techacademy.kenji.takada.taskapp.Task newObject, boolean update, Map<RealmModel,RealmObjectProxy> cache, Set<ImportFlag> flags) {
        RealmObjectProxy cachedRealmObject = cache.get(newObject);
        if (cachedRealmObject != null) {
            return (jp.techacademy.kenji.takada.taskapp.Task) cachedRealmObject;
        }

        jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface realmObjectSource = (jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) newObject;

        Table table = realm.getTable(jp.techacademy.kenji.takada.taskapp.Task.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);

        // Add all non-"object reference" fields
        builder.addString(columnInfo.titleColKey, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.contentsColKey, realmObjectSource.realmGet$contents());
        builder.addDate(columnInfo.dateColKey, realmObjectSource.realmGet$date());
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());

        // Create the underlying object and cache it before setting any object/objectlist references
        // This will allow us to break any circular dependencies by using the object cache.
        Row row = builder.createNewObject();
        io.realm.jp_techacademy_kenji_takada_taskapp_TaskRealmProxy realmObjectCopy = newProxyInstance(realm, row);
        cache.put(newObject, realmObjectCopy);

        return realmObjectCopy;
    }

    public static long insert(Realm realm, jp.techacademy.kenji.takada.taskapp.Task object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(jp.techacademy.kenji.takada.taskapp.Task.class);
        long tableNativePtr = table.getNativePtr();
        TaskColumnInfo columnInfo = (TaskColumnInfo) realm.getSchema().getColumnInfo(jp.techacademy.kenji.takada.taskapp.Task.class);
        long pkColumnKey = columnInfo.idColKey;
        long colKey = Table.NO_MATCH;
        Object primaryKeyValue = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            colKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id());
        }
        if (colKey == Table.NO_MATCH) {
            colKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id());
        } else {
            Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
        }
        cache.put(object, colKey);
        String realmGet$title = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleColKey, colKey, realmGet$title, false);
        }
        String realmGet$contents = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$contents();
        if (realmGet$contents != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentsColKey, colKey, realmGet$contents, false);
        }
        java.util.Date realmGet$date = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateColKey, colKey, realmGet$date.getTime(), false);
        }
        return colKey;
    }

    public static void insert(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(jp.techacademy.kenji.takada.taskapp.Task.class);
        long tableNativePtr = table.getNativePtr();
        TaskColumnInfo columnInfo = (TaskColumnInfo) realm.getSchema().getColumnInfo(jp.techacademy.kenji.takada.taskapp.Task.class);
        long pkColumnKey = columnInfo.idColKey;
        jp.techacademy.kenji.takada.taskapp.Task object = null;
        while (objects.hasNext()) {
            object = (jp.techacademy.kenji.takada.taskapp.Task) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long colKey = Table.NO_MATCH;
            Object primaryKeyValue = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                colKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id());
            }
            if (colKey == Table.NO_MATCH) {
                colKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id());
            } else {
                Table.throwDuplicatePrimaryKeyException(primaryKeyValue);
            }
            cache.put(object, colKey);
            String realmGet$title = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleColKey, colKey, realmGet$title, false);
            }
            String realmGet$contents = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$contents();
            if (realmGet$contents != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentsColKey, colKey, realmGet$contents, false);
            }
            java.util.Date realmGet$date = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$date();
            if (realmGet$date != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateColKey, colKey, realmGet$date.getTime(), false);
            }
        }
    }

    public static long insertOrUpdate(Realm realm, jp.techacademy.kenji.takada.taskapp.Task object, Map<RealmModel,Long> cache) {
        if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
            return ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey();
        }
        Table table = realm.getTable(jp.techacademy.kenji.takada.taskapp.Task.class);
        long tableNativePtr = table.getNativePtr();
        TaskColumnInfo columnInfo = (TaskColumnInfo) realm.getSchema().getColumnInfo(jp.techacademy.kenji.takada.taskapp.Task.class);
        long pkColumnKey = columnInfo.idColKey;
        long colKey = Table.NO_MATCH;
        Object primaryKeyValue = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id();
        if (primaryKeyValue != null) {
            colKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id());
        }
        if (colKey == Table.NO_MATCH) {
            colKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id());
        }
        cache.put(object, colKey);
        String realmGet$title = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$title();
        if (realmGet$title != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.titleColKey, colKey, realmGet$title, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.titleColKey, colKey, false);
        }
        String realmGet$contents = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$contents();
        if (realmGet$contents != null) {
            Table.nativeSetString(tableNativePtr, columnInfo.contentsColKey, colKey, realmGet$contents, false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.contentsColKey, colKey, false);
        }
        java.util.Date realmGet$date = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$date();
        if (realmGet$date != null) {
            Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateColKey, colKey, realmGet$date.getTime(), false);
        } else {
            Table.nativeSetNull(tableNativePtr, columnInfo.dateColKey, colKey, false);
        }
        return colKey;
    }

    public static void insertOrUpdate(Realm realm, Iterator<? extends RealmModel> objects, Map<RealmModel,Long> cache) {
        Table table = realm.getTable(jp.techacademy.kenji.takada.taskapp.Task.class);
        long tableNativePtr = table.getNativePtr();
        TaskColumnInfo columnInfo = (TaskColumnInfo) realm.getSchema().getColumnInfo(jp.techacademy.kenji.takada.taskapp.Task.class);
        long pkColumnKey = columnInfo.idColKey;
        jp.techacademy.kenji.takada.taskapp.Task object = null;
        while (objects.hasNext()) {
            object = (jp.techacademy.kenji.takada.taskapp.Task) objects.next();
            if (cache.containsKey(object)) {
                continue;
            }
            if (object instanceof RealmObjectProxy && !RealmObject.isFrozen(object) && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm() != null && ((RealmObjectProxy) object).realmGet$proxyState().getRealm$realm().getPath().equals(realm.getPath())) {
                cache.put(object, ((RealmObjectProxy) object).realmGet$proxyState().getRow$realm().getObjectKey());
                continue;
            }
            long colKey = Table.NO_MATCH;
            Object primaryKeyValue = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id();
            if (primaryKeyValue != null) {
                colKey = Table.nativeFindFirstInt(tableNativePtr, pkColumnKey, ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id());
            }
            if (colKey == Table.NO_MATCH) {
                colKey = OsObject.createRowWithPrimaryKey(table, pkColumnKey, ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$id());
            }
            cache.put(object, colKey);
            String realmGet$title = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$title();
            if (realmGet$title != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.titleColKey, colKey, realmGet$title, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.titleColKey, colKey, false);
            }
            String realmGet$contents = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$contents();
            if (realmGet$contents != null) {
                Table.nativeSetString(tableNativePtr, columnInfo.contentsColKey, colKey, realmGet$contents, false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.contentsColKey, colKey, false);
            }
            java.util.Date realmGet$date = ((jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) object).realmGet$date();
            if (realmGet$date != null) {
                Table.nativeSetTimestamp(tableNativePtr, columnInfo.dateColKey, colKey, realmGet$date.getTime(), false);
            } else {
                Table.nativeSetNull(tableNativePtr, columnInfo.dateColKey, colKey, false);
            }
        }
    }

    public static jp.techacademy.kenji.takada.taskapp.Task createDetachedCopy(jp.techacademy.kenji.takada.taskapp.Task realmObject, int currentDepth, int maxDepth, Map<RealmModel, CacheData<RealmModel>> cache) {
        if (currentDepth > maxDepth || realmObject == null) {
            return null;
        }
        CacheData<RealmModel> cachedObject = cache.get(realmObject);
        jp.techacademy.kenji.takada.taskapp.Task unmanagedObject;
        if (cachedObject == null) {
            unmanagedObject = new jp.techacademy.kenji.takada.taskapp.Task();
            cache.put(realmObject, new RealmObjectProxy.CacheData<RealmModel>(currentDepth, unmanagedObject));
        } else {
            // Reuse cached object or recreate it because it was encountered at a lower depth.
            if (currentDepth >= cachedObject.minDepth) {
                return (jp.techacademy.kenji.takada.taskapp.Task) cachedObject.object;
            }
            unmanagedObject = (jp.techacademy.kenji.takada.taskapp.Task) cachedObject.object;
            cachedObject.minDepth = currentDepth;
        }
        jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface unmanagedCopy = (jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) unmanagedObject;
        jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface realmSource = (jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) realmObject;
        unmanagedCopy.realmSet$title(realmSource.realmGet$title());
        unmanagedCopy.realmSet$contents(realmSource.realmGet$contents());
        unmanagedCopy.realmSet$date(realmSource.realmGet$date());
        unmanagedCopy.realmSet$id(realmSource.realmGet$id());

        return unmanagedObject;
    }

    static jp.techacademy.kenji.takada.taskapp.Task update(Realm realm, TaskColumnInfo columnInfo, jp.techacademy.kenji.takada.taskapp.Task realmObject, jp.techacademy.kenji.takada.taskapp.Task newObject, Map<RealmModel, RealmObjectProxy> cache, Set<ImportFlag> flags) {
        jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface realmObjectTarget = (jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) realmObject;
        jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface realmObjectSource = (jp_techacademy_kenji_takada_taskapp_TaskRealmProxyInterface) newObject;
        Table table = realm.getTable(jp.techacademy.kenji.takada.taskapp.Task.class);
        OsObjectBuilder builder = new OsObjectBuilder(table, flags);
        builder.addString(columnInfo.titleColKey, realmObjectSource.realmGet$title());
        builder.addString(columnInfo.contentsColKey, realmObjectSource.realmGet$contents());
        builder.addDate(columnInfo.dateColKey, realmObjectSource.realmGet$date());
        builder.addInteger(columnInfo.idColKey, realmObjectSource.realmGet$id());

        builder.updateExistingObject();
        return realmObject;
    }

    @Override
    @SuppressWarnings("ArrayToString")
    public String toString() {
        if (!RealmObject.isValid(this)) {
            return "Invalid object";
        }
        StringBuilder stringBuilder = new StringBuilder("Task = proxy[");
        stringBuilder.append("{title:");
        stringBuilder.append(realmGet$title());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{contents:");
        stringBuilder.append(realmGet$contents());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{date:");
        stringBuilder.append(realmGet$date());
        stringBuilder.append("}");
        stringBuilder.append(",");
        stringBuilder.append("{id:");
        stringBuilder.append(realmGet$id());
        stringBuilder.append("}");
        stringBuilder.append("]");
        return stringBuilder.toString();
    }

    @Override
    public ProxyState<?> realmGet$proxyState() {
        return proxyState;
    }

    @Override
    public int hashCode() {
        String realmName = proxyState.getRealm$realm().getPath();
        String tableName = proxyState.getRow$realm().getTable().getName();
        long colKey = proxyState.getRow$realm().getObjectKey();

        int result = 17;
        result = 31 * result + ((realmName != null) ? realmName.hashCode() : 0);
        result = 31 * result + ((tableName != null) ? tableName.hashCode() : 0);
        result = 31 * result + (int) (colKey ^ (colKey >>> 32));
        return result;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        jp_techacademy_kenji_takada_taskapp_TaskRealmProxy aTask = (jp_techacademy_kenji_takada_taskapp_TaskRealmProxy)o;

        BaseRealm realm = proxyState.getRealm$realm();
        BaseRealm otherRealm = aTask.proxyState.getRealm$realm();
        String path = realm.getPath();
        String otherPath = otherRealm.getPath();
        if (path != null ? !path.equals(otherPath) : otherPath != null) return false;
        if (realm.isFrozen() != otherRealm.isFrozen()) return false;
        if (!realm.sharedRealm.getVersionID().equals(otherRealm.sharedRealm.getVersionID())) {
            return false;
        }

        String tableName = proxyState.getRow$realm().getTable().getName();
        String otherTableName = aTask.proxyState.getRow$realm().getTable().getName();
        if (tableName != null ? !tableName.equals(otherTableName) : otherTableName != null) return false;

        if (proxyState.getRow$realm().getObjectKey() != aTask.proxyState.getRow$realm().getObjectKey()) return false;

        return true;
    }
}
