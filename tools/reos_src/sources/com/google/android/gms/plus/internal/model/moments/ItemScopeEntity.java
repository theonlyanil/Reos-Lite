package com.google.android.gms.plus.internal.model.moments;

import android.os.Parcel;
import com.android.library.userprofile.util.Constants;
import com.google.android.gms.common.server.response.FastJsonResponse;
import com.google.android.gms.common.server.response.FastSafeParcelableJsonResponse;
import com.google.android.gms.plus.PlusShare;
import com.google.android.gms.plus.model.moments.ItemScope;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public final class ItemScopeEntity extends FastSafeParcelableJsonResponse implements ItemScope {
    public static final zza CREATOR = new zza();
    private static final HashMap<String, FastJsonResponse.Field<?, ?>> zzaZz = new HashMap<>();
    String mName;
    final int mVersionCode;
    String zzF;
    String zzIx;
    double zzaKR;
    double zzaKS;
    final Set<Integer> zzaZA;
    ItemScopeEntity zzaZB;
    List<String> zzaZC;
    ItemScopeEntity zzaZD;
    String zzaZE;
    String zzaZF;
    String zzaZG;
    List<ItemScopeEntity> zzaZH;
    int zzaZI;
    List<ItemScopeEntity> zzaZJ;
    ItemScopeEntity zzaZK;
    List<ItemScopeEntity> zzaZL;
    String zzaZM;
    String zzaZN;
    ItemScopeEntity zzaZO;
    String zzaZP;
    String zzaZQ;
    List<ItemScopeEntity> zzaZR;
    String zzaZS;
    String zzaZT;
    String zzaZU;
    String zzaZV;
    String zzaZW;
    String zzaZX;
    String zzaZY;
    String zzaZZ;
    String zzavc;
    ItemScopeEntity zzbaa;
    String zzbab;
    String zzbac;
    String zzbad;
    ItemScopeEntity zzbae;
    ItemScopeEntity zzbaf;
    ItemScopeEntity zzbag;
    List<ItemScopeEntity> zzbah;
    String zzbai;
    String zzbaj;
    String zzbak;
    String zzbal;
    ItemScopeEntity zzbam;
    String zzban;
    String zzbao;
    String zzbap;
    ItemScopeEntity zzbaq;
    String zzbar;
    String zzbas;
    String zzbat;
    String zzbau;
    String zztN;
    String zzxX;

    static {
        zzaZz.put("about", FastJsonResponse.Field.zza("about", 2, ItemScopeEntity.class));
        zzaZz.put("additionalName", FastJsonResponse.Field.zzm("additionalName", 3));
        zzaZz.put(Constants.SMS_COLUMN_ADDRESS, FastJsonResponse.Field.zza(Constants.SMS_COLUMN_ADDRESS, 4, ItemScopeEntity.class));
        zzaZz.put("addressCountry", FastJsonResponse.Field.zzl("addressCountry", 5));
        zzaZz.put("addressLocality", FastJsonResponse.Field.zzl("addressLocality", 6));
        zzaZz.put("addressRegion", FastJsonResponse.Field.zzl("addressRegion", 7));
        zzaZz.put("associated_media", FastJsonResponse.Field.zzb("associated_media", 8, ItemScopeEntity.class));
        zzaZz.put("attendeeCount", FastJsonResponse.Field.zzi("attendeeCount", 9));
        zzaZz.put("attendees", FastJsonResponse.Field.zzb("attendees", 10, ItemScopeEntity.class));
        zzaZz.put("audio", FastJsonResponse.Field.zza("audio", 11, ItemScopeEntity.class));
        zzaZz.put("author", FastJsonResponse.Field.zzb("author", 12, ItemScopeEntity.class));
        zzaZz.put("bestRating", FastJsonResponse.Field.zzl("bestRating", 13));
        zzaZz.put("birthDate", FastJsonResponse.Field.zzl("birthDate", 14));
        zzaZz.put("byArtist", FastJsonResponse.Field.zza("byArtist", 15, ItemScopeEntity.class));
        zzaZz.put("caption", FastJsonResponse.Field.zzl("caption", 16));
        zzaZz.put("contentSize", FastJsonResponse.Field.zzl("contentSize", 17));
        zzaZz.put("contentUrl", FastJsonResponse.Field.zzl("contentUrl", 18));
        zzaZz.put("contributor", FastJsonResponse.Field.zzb("contributor", 19, ItemScopeEntity.class));
        zzaZz.put("dateCreated", FastJsonResponse.Field.zzl("dateCreated", 20));
        zzaZz.put("dateModified", FastJsonResponse.Field.zzl("dateModified", 21));
        zzaZz.put("datePublished", FastJsonResponse.Field.zzl("datePublished", 22));
        zzaZz.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_DESCRIPTION, 23));
        zzaZz.put("duration", FastJsonResponse.Field.zzl("duration", 24));
        zzaZz.put("embedUrl", FastJsonResponse.Field.zzl("embedUrl", 25));
        zzaZz.put("endDate", FastJsonResponse.Field.zzl("endDate", 26));
        zzaZz.put("familyName", FastJsonResponse.Field.zzl("familyName", 27));
        zzaZz.put("gender", FastJsonResponse.Field.zzl("gender", 28));
        zzaZz.put("geo", FastJsonResponse.Field.zza("geo", 29, ItemScopeEntity.class));
        zzaZz.put("givenName", FastJsonResponse.Field.zzl("givenName", 30));
        zzaZz.put("height", FastJsonResponse.Field.zzl("height", 31));
        zzaZz.put("id", FastJsonResponse.Field.zzl("id", 32));
        zzaZz.put("image", FastJsonResponse.Field.zzl("image", 33));
        zzaZz.put("inAlbum", FastJsonResponse.Field.zza("inAlbum", 34, ItemScopeEntity.class));
        zzaZz.put("latitude", FastJsonResponse.Field.zzj("latitude", 36));
        zzaZz.put("location", FastJsonResponse.Field.zza("location", 37, ItemScopeEntity.class));
        zzaZz.put("longitude", FastJsonResponse.Field.zzj("longitude", 38));
        zzaZz.put("name", FastJsonResponse.Field.zzl("name", 39));
        zzaZz.put("partOfTVSeries", FastJsonResponse.Field.zza("partOfTVSeries", 40, ItemScopeEntity.class));
        zzaZz.put("performers", FastJsonResponse.Field.zzb("performers", 41, ItemScopeEntity.class));
        zzaZz.put("playerType", FastJsonResponse.Field.zzl("playerType", 42));
        zzaZz.put("postOfficeBoxNumber", FastJsonResponse.Field.zzl("postOfficeBoxNumber", 43));
        zzaZz.put("postalCode", FastJsonResponse.Field.zzl("postalCode", 44));
        zzaZz.put("ratingValue", FastJsonResponse.Field.zzl("ratingValue", 45));
        zzaZz.put("reviewRating", FastJsonResponse.Field.zza("reviewRating", 46, ItemScopeEntity.class));
        zzaZz.put("startDate", FastJsonResponse.Field.zzl("startDate", 47));
        zzaZz.put("streetAddress", FastJsonResponse.Field.zzl("streetAddress", 48));
        zzaZz.put("text", FastJsonResponse.Field.zzl("text", 49));
        zzaZz.put("thumbnail", FastJsonResponse.Field.zza("thumbnail", 50, ItemScopeEntity.class));
        zzaZz.put(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CONTENT_DEEP_LINK_METADATA_THUMBNAIL_URL, 51));
        zzaZz.put("tickerSymbol", FastJsonResponse.Field.zzl("tickerSymbol", 52));
        zzaZz.put(Constants.SMS_COLUMN_TYPE, FastJsonResponse.Field.zzl(Constants.SMS_COLUMN_TYPE, 53));
        zzaZz.put(PlusShare.KEY_CALL_TO_ACTION_URL, FastJsonResponse.Field.zzl(PlusShare.KEY_CALL_TO_ACTION_URL, 54));
        zzaZz.put("width", FastJsonResponse.Field.zzl("width", 55));
        zzaZz.put("worstRating", FastJsonResponse.Field.zzl("worstRating", 56));
    }

    public ItemScopeEntity() {
        this.mVersionCode = 1;
        this.zzaZA = new HashSet();
    }

    ItemScopeEntity(Set<Integer> set, int i, ItemScopeEntity itemScopeEntity, List<String> list, ItemScopeEntity itemScopeEntity2, String str, String str2, String str3, List<ItemScopeEntity> list2, int i2, List<ItemScopeEntity> list3, ItemScopeEntity itemScopeEntity3, List<ItemScopeEntity> list4, String str4, String str5, ItemScopeEntity itemScopeEntity4, String str6, String str7, String str8, List<ItemScopeEntity> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ItemScopeEntity itemScopeEntity5, String str18, String str19, String str20, String str21, ItemScopeEntity itemScopeEntity6, double d2, ItemScopeEntity itemScopeEntity7, double d3, String str22, ItemScopeEntity itemScopeEntity8, List<ItemScopeEntity> list6, String str23, String str24, String str25, String str26, ItemScopeEntity itemScopeEntity9, String str27, String str28, String str29, ItemScopeEntity itemScopeEntity10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.zzaZA = set;
        this.mVersionCode = i;
        this.zzaZB = itemScopeEntity;
        this.zzaZC = list;
        this.zzaZD = itemScopeEntity2;
        this.zzaZE = str;
        this.zzaZF = str2;
        this.zzaZG = str3;
        this.zzaZH = list2;
        this.zzaZI = i2;
        this.zzaZJ = list3;
        this.zzaZK = itemScopeEntity3;
        this.zzaZL = list4;
        this.zzaZM = str4;
        this.zzaZN = str5;
        this.zzaZO = itemScopeEntity4;
        this.zzaZP = str6;
        this.zzaZQ = str7;
        this.zztN = str8;
        this.zzaZR = list5;
        this.zzaZS = str9;
        this.zzaZT = str10;
        this.zzaZU = str11;
        this.zzavc = str12;
        this.zzaZV = str13;
        this.zzaZW = str14;
        this.zzaZX = str15;
        this.zzaZY = str16;
        this.zzaZZ = str17;
        this.zzbaa = itemScopeEntity5;
        this.zzbab = str18;
        this.zzbac = str19;
        this.zzxX = str20;
        this.zzbad = str21;
        this.zzbae = itemScopeEntity6;
        this.zzaKR = d2;
        this.zzbaf = itemScopeEntity7;
        this.zzaKS = d3;
        this.mName = str22;
        this.zzbag = itemScopeEntity8;
        this.zzbah = list6;
        this.zzbai = str23;
        this.zzbaj = str24;
        this.zzbak = str25;
        this.zzbal = str26;
        this.zzbam = itemScopeEntity9;
        this.zzban = str27;
        this.zzbao = str28;
        this.zzbap = str29;
        this.zzbaq = itemScopeEntity10;
        this.zzbar = str30;
        this.zzbas = str31;
        this.zzIx = str32;
        this.zzF = str33;
        this.zzbat = str34;
        this.zzbau = str35;
    }

    public ItemScopeEntity(Set<Integer> set, ItemScopeEntity itemScopeEntity, List<String> list, ItemScopeEntity itemScopeEntity2, String str, String str2, String str3, List<ItemScopeEntity> list2, int i, List<ItemScopeEntity> list3, ItemScopeEntity itemScopeEntity3, List<ItemScopeEntity> list4, String str4, String str5, ItemScopeEntity itemScopeEntity4, String str6, String str7, String str8, List<ItemScopeEntity> list5, String str9, String str10, String str11, String str12, String str13, String str14, String str15, String str16, String str17, ItemScopeEntity itemScopeEntity5, String str18, String str19, String str20, String str21, ItemScopeEntity itemScopeEntity6, double d2, ItemScopeEntity itemScopeEntity7, double d3, String str22, ItemScopeEntity itemScopeEntity8, List<ItemScopeEntity> list6, String str23, String str24, String str25, String str26, ItemScopeEntity itemScopeEntity9, String str27, String str28, String str29, ItemScopeEntity itemScopeEntity10, String str30, String str31, String str32, String str33, String str34, String str35) {
        this.zzaZA = set;
        this.mVersionCode = 1;
        this.zzaZB = itemScopeEntity;
        this.zzaZC = list;
        this.zzaZD = itemScopeEntity2;
        this.zzaZE = str;
        this.zzaZF = str2;
        this.zzaZG = str3;
        this.zzaZH = list2;
        this.zzaZI = i;
        this.zzaZJ = list3;
        this.zzaZK = itemScopeEntity3;
        this.zzaZL = list4;
        this.zzaZM = str4;
        this.zzaZN = str5;
        this.zzaZO = itemScopeEntity4;
        this.zzaZP = str6;
        this.zzaZQ = str7;
        this.zztN = str8;
        this.zzaZR = list5;
        this.zzaZS = str9;
        this.zzaZT = str10;
        this.zzaZU = str11;
        this.zzavc = str12;
        this.zzaZV = str13;
        this.zzaZW = str14;
        this.zzaZX = str15;
        this.zzaZY = str16;
        this.zzaZZ = str17;
        this.zzbaa = itemScopeEntity5;
        this.zzbab = str18;
        this.zzbac = str19;
        this.zzxX = str20;
        this.zzbad = str21;
        this.zzbae = itemScopeEntity6;
        this.zzaKR = d2;
        this.zzbaf = itemScopeEntity7;
        this.zzaKS = d3;
        this.mName = str22;
        this.zzbag = itemScopeEntity8;
        this.zzbah = list6;
        this.zzbai = str23;
        this.zzbaj = str24;
        this.zzbak = str25;
        this.zzbal = str26;
        this.zzbam = itemScopeEntity9;
        this.zzban = str27;
        this.zzbao = str28;
        this.zzbap = str29;
        this.zzbaq = itemScopeEntity10;
        this.zzbar = str30;
        this.zzbas = str31;
        this.zzIx = str32;
        this.zzF = str33;
        this.zzbat = str34;
        this.zzbau = str35;
    }

    @Override // android.os.Parcelable
    public int describeContents() {
        zza zzaVar = CREATOR;
        return 0;
    }

    public boolean equals(Object obj) {
        if (!(obj instanceof ItemScopeEntity)) {
            return false;
        }
        if (this == obj) {
            return true;
        }
        ItemScopeEntity itemScopeEntity = (ItemScopeEntity) obj;
        for (FastJsonResponse.Field<?, ?> field : zzaZz.values()) {
            if (zza(field)) {
                if (itemScopeEntity.zza(field) && zzb(field).equals(itemScopeEntity.zzb(field))) {
                }
                return false;
            }
            if (itemScopeEntity.zza(field)) {
                return false;
            }
        }
        return true;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getAbout() {
        return this.zzaZB;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<String> getAdditionalName() {
        return this.zzaZC;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getAddress() {
        return this.zzaZD;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getAddressCountry() {
        return this.zzaZE;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getAddressLocality() {
        return this.zzaZF;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getAddressRegion() {
        return this.zzaZG;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getAssociated_media() {
        return (ArrayList) this.zzaZH;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public int getAttendeeCount() {
        return this.zzaZI;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getAttendees() {
        return (ArrayList) this.zzaZJ;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getAudio() {
        return this.zzaZK;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getAuthor() {
        return (ArrayList) this.zzaZL;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getBestRating() {
        return this.zzaZM;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getBirthDate() {
        return this.zzaZN;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getByArtist() {
        return this.zzaZO;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getCaption() {
        return this.zzaZP;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getContentSize() {
        return this.zzaZQ;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getContentUrl() {
        return this.zztN;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getContributor() {
        return (ArrayList) this.zzaZR;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDateCreated() {
        return this.zzaZS;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDateModified() {
        return this.zzaZT;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDatePublished() {
        return this.zzaZU;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDescription() {
        return this.zzavc;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getDuration() {
        return this.zzaZV;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getEmbedUrl() {
        return this.zzaZW;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getEndDate() {
        return this.zzaZX;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getFamilyName() {
        return this.zzaZY;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getGender() {
        return this.zzaZZ;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getGeo() {
        return this.zzbaa;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getGivenName() {
        return this.zzbab;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getHeight() {
        return this.zzbac;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getId() {
        return this.zzxX;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getImage() {
        return this.zzbad;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getInAlbum() {
        return this.zzbae;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public double getLatitude() {
        return this.zzaKR;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getLocation() {
        return this.zzbaf;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public double getLongitude() {
        return this.zzaKS;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getName() {
        return this.mName;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getPartOfTVSeries() {
        return this.zzbag;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public List<ItemScope> getPerformers() {
        return (ArrayList) this.zzbah;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getPlayerType() {
        return this.zzbai;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getPostOfficeBoxNumber() {
        return this.zzbaj;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getPostalCode() {
        return this.zzbak;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getRatingValue() {
        return this.zzbal;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getReviewRating() {
        return this.zzbam;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getStartDate() {
        return this.zzban;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getStreetAddress() {
        return this.zzbao;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getText() {
        return this.zzbap;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public ItemScope getThumbnail() {
        return this.zzbaq;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getThumbnailUrl() {
        return this.zzbar;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getTickerSymbol() {
        return this.zzbas;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getType() {
        return this.zzIx;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getUrl() {
        return this.zzF;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getWidth() {
        return this.zzbat;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public String getWorstRating() {
        return this.zzbau;
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAbout() {
        return this.zzaZA.contains(2);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAdditionalName() {
        return this.zzaZA.contains(3);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAddress() {
        return this.zzaZA.contains(4);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAddressCountry() {
        return this.zzaZA.contains(5);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAddressLocality() {
        return this.zzaZA.contains(6);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAddressRegion() {
        return this.zzaZA.contains(7);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAssociated_media() {
        return this.zzaZA.contains(8);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAttendeeCount() {
        return this.zzaZA.contains(9);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAttendees() {
        return this.zzaZA.contains(10);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAudio() {
        return this.zzaZA.contains(11);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasAuthor() {
        return this.zzaZA.contains(12);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasBestRating() {
        return this.zzaZA.contains(13);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasBirthDate() {
        return this.zzaZA.contains(14);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasByArtist() {
        return this.zzaZA.contains(15);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasCaption() {
        return this.zzaZA.contains(16);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasContentSize() {
        return this.zzaZA.contains(17);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasContentUrl() {
        return this.zzaZA.contains(18);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasContributor() {
        return this.zzaZA.contains(19);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDateCreated() {
        return this.zzaZA.contains(20);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDateModified() {
        return this.zzaZA.contains(21);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDatePublished() {
        return this.zzaZA.contains(22);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDescription() {
        return this.zzaZA.contains(23);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasDuration() {
        return this.zzaZA.contains(24);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasEmbedUrl() {
        return this.zzaZA.contains(25);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasEndDate() {
        return this.zzaZA.contains(26);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasFamilyName() {
        return this.zzaZA.contains(27);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasGender() {
        return this.zzaZA.contains(28);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasGeo() {
        return this.zzaZA.contains(29);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasGivenName() {
        return this.zzaZA.contains(30);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasHeight() {
        return this.zzaZA.contains(31);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasId() {
        return this.zzaZA.contains(32);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasImage() {
        return this.zzaZA.contains(33);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasInAlbum() {
        return this.zzaZA.contains(34);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasLatitude() {
        return this.zzaZA.contains(36);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasLocation() {
        return this.zzaZA.contains(37);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasLongitude() {
        return this.zzaZA.contains(38);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasName() {
        return this.zzaZA.contains(39);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPartOfTVSeries() {
        return this.zzaZA.contains(40);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPerformers() {
        return this.zzaZA.contains(41);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPlayerType() {
        return this.zzaZA.contains(42);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPostOfficeBoxNumber() {
        return this.zzaZA.contains(43);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasPostalCode() {
        return this.zzaZA.contains(44);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasRatingValue() {
        return this.zzaZA.contains(45);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasReviewRating() {
        return this.zzaZA.contains(46);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasStartDate() {
        return this.zzaZA.contains(47);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasStreetAddress() {
        return this.zzaZA.contains(48);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasText() {
        return this.zzaZA.contains(49);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasThumbnail() {
        return this.zzaZA.contains(50);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasThumbnailUrl() {
        return this.zzaZA.contains(51);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasTickerSymbol() {
        return this.zzaZA.contains(52);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasType() {
        return this.zzaZA.contains(53);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasUrl() {
        return this.zzaZA.contains(54);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasWidth() {
        return this.zzaZA.contains(55);
    }

    @Override // com.google.android.gms.plus.model.moments.ItemScope
    public boolean hasWorstRating() {
        return this.zzaZA.contains(56);
    }

    public int hashCode() {
        int iHashCode = 0;
        Iterator<FastJsonResponse.Field<?, ?>> it = zzaZz.values().iterator();
        while (true) {
            int i = iHashCode;
            if (!it.hasNext()) {
                return i;
            }
            FastJsonResponse.Field<?, ?> next = it.next();
            if (zza(next)) {
                iHashCode = zzb(next).hashCode() + i + next.zzrc();
            } else {
                iHashCode = i;
            }
        }
    }

    @Override // com.google.android.gms.common.data.Freezable
    public boolean isDataValid() {
        return true;
    }

    @Override // android.os.Parcelable
    public void writeToParcel(Parcel parcel, int i) {
        zza zzaVar = CREATOR;
        zza.zza(this, parcel, i);
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    /* JADX INFO: renamed from: zzDq, reason: merged with bridge method [inline-methods] */
    public HashMap<String, FastJsonResponse.Field<?, ?>> zzqV() {
        return zzaZz;
    }

    @Override // com.google.android.gms.common.data.Freezable
    /* JADX INFO: renamed from: zzDr, reason: merged with bridge method [inline-methods] */
    public ItemScopeEntity freeze() {
        return this;
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected boolean zza(FastJsonResponse.Field field) {
        return this.zzaZA.contains(Integer.valueOf(field.zzrc()));
    }

    @Override // com.google.android.gms.common.server.response.FastJsonResponse
    protected Object zzb(FastJsonResponse.Field field) {
        switch (field.zzrc()) {
            case 2:
                return this.zzaZB;
            case 3:
                return this.zzaZC;
            case 4:
                return this.zzaZD;
            case 5:
                return this.zzaZE;
            case 6:
                return this.zzaZF;
            case 7:
                return this.zzaZG;
            case 8:
                return this.zzaZH;
            case 9:
                return Integer.valueOf(this.zzaZI);
            case 10:
                return this.zzaZJ;
            case 11:
                return this.zzaZK;
            case 12:
                return this.zzaZL;
            case 13:
                return this.zzaZM;
            case 14:
                return this.zzaZN;
            case 15:
                return this.zzaZO;
            case 16:
                return this.zzaZP;
            case 17:
                return this.zzaZQ;
            case 18:
                return this.zztN;
            case 19:
                return this.zzaZR;
            case 20:
                return this.zzaZS;
            case 21:
                return this.zzaZT;
            case 22:
                return this.zzaZU;
            case 23:
                return this.zzavc;
            case 24:
                return this.zzaZV;
            case 25:
                return this.zzaZW;
            case 26:
                return this.zzaZX;
            case 27:
                return this.zzaZY;
            case 28:
                return this.zzaZZ;
            case 29:
                return this.zzbaa;
            case 30:
                return this.zzbab;
            case 31:
                return this.zzbac;
            case 32:
                return this.zzxX;
            case 33:
                return this.zzbad;
            case 34:
                return this.zzbae;
            case 35:
            default:
                throw new IllegalStateException("Unknown safe parcelable id=" + field.zzrc());
            case 36:
                return Double.valueOf(this.zzaKR);
            case 37:
                return this.zzbaf;
            case 38:
                return Double.valueOf(this.zzaKS);
            case 39:
                return this.mName;
            case 40:
                return this.zzbag;
            case 41:
                return this.zzbah;
            case 42:
                return this.zzbai;
            case 43:
                return this.zzbaj;
            case 44:
                return this.zzbak;
            case 45:
                return this.zzbal;
            case 46:
                return this.zzbam;
            case 47:
                return this.zzban;
            case 48:
                return this.zzbao;
            case 49:
                return this.zzbap;
            case 50:
                return this.zzbaq;
            case 51:
                return this.zzbar;
            case 52:
                return this.zzbas;
            case 53:
                return this.zzIx;
            case 54:
                return this.zzF;
            case 55:
                return this.zzbat;
            case 56:
                return this.zzbau;
        }
    }
}
