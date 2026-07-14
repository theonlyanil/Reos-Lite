package com.google.android.gms.plus.model.moments;

import com.google.android.gms.common.data.Freezable;
import com.google.android.gms.plus.internal.model.moments.ItemScopeEntity;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

/* JADX INFO: loaded from: classes.dex */
public interface ItemScope extends Freezable<ItemScope> {

    public static class Builder {
        private String mName;
        private String zzF;
        private String zzIx;
        private double zzaKR;
        private double zzaKS;
        private final Set<Integer> zzaZA = new HashSet();
        private ItemScopeEntity zzaZB;
        private List<String> zzaZC;
        private ItemScopeEntity zzaZD;
        private String zzaZE;
        private String zzaZF;
        private String zzaZG;
        private List<ItemScopeEntity> zzaZH;
        private int zzaZI;
        private List<ItemScopeEntity> zzaZJ;
        private ItemScopeEntity zzaZK;
        private List<ItemScopeEntity> zzaZL;
        private String zzaZM;
        private String zzaZN;
        private ItemScopeEntity zzaZO;
        private String zzaZP;
        private String zzaZQ;
        private List<ItemScopeEntity> zzaZR;
        private String zzaZS;
        private String zzaZT;
        private String zzaZU;
        private String zzaZV;
        private String zzaZW;
        private String zzaZX;
        private String zzaZY;
        private String zzaZZ;
        private String zzavc;
        private ItemScopeEntity zzbaa;
        private String zzbab;
        private String zzbac;
        private String zzbad;
        private ItemScopeEntity zzbae;
        private ItemScopeEntity zzbaf;
        private ItemScopeEntity zzbag;
        private List<ItemScopeEntity> zzbah;
        private String zzbai;
        private String zzbaj;
        private String zzbak;
        private String zzbal;
        private ItemScopeEntity zzbam;
        private String zzban;
        private String zzbao;
        private String zzbap;
        private ItemScopeEntity zzbaq;
        private String zzbar;
        private String zzbas;
        private String zzbat;
        private String zzbau;
        private String zztN;
        private String zzxX;

        public ItemScope build() {
            return new ItemScopeEntity(this.zzaZA, this.zzaZB, this.zzaZC, this.zzaZD, this.zzaZE, this.zzaZF, this.zzaZG, this.zzaZH, this.zzaZI, this.zzaZJ, this.zzaZK, this.zzaZL, this.zzaZM, this.zzaZN, this.zzaZO, this.zzaZP, this.zzaZQ, this.zztN, this.zzaZR, this.zzaZS, this.zzaZT, this.zzaZU, this.zzavc, this.zzaZV, this.zzaZW, this.zzaZX, this.zzaZY, this.zzaZZ, this.zzbaa, this.zzbab, this.zzbac, this.zzxX, this.zzbad, this.zzbae, this.zzaKR, this.zzbaf, this.zzaKS, this.mName, this.zzbag, this.zzbah, this.zzbai, this.zzbaj, this.zzbak, this.zzbal, this.zzbam, this.zzban, this.zzbao, this.zzbap, this.zzbaq, this.zzbar, this.zzbas, this.zzIx, this.zzF, this.zzbat, this.zzbau);
        }

        public Builder setAbout(ItemScope itemScope) {
            this.zzaZB = (ItemScopeEntity) itemScope;
            this.zzaZA.add(2);
            return this;
        }

        public Builder setAdditionalName(List<String> list) {
            this.zzaZC = list;
            this.zzaZA.add(3);
            return this;
        }

        public Builder setAddress(ItemScope itemScope) {
            this.zzaZD = (ItemScopeEntity) itemScope;
            this.zzaZA.add(4);
            return this;
        }

        public Builder setAddressCountry(String str) {
            this.zzaZE = str;
            this.zzaZA.add(5);
            return this;
        }

        public Builder setAddressLocality(String str) {
            this.zzaZF = str;
            this.zzaZA.add(6);
            return this;
        }

        public Builder setAddressRegion(String str) {
            this.zzaZG = str;
            this.zzaZA.add(7);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setAssociated_media(List<ItemScope> list) {
            this.zzaZH = list;
            this.zzaZA.add(8);
            return this;
        }

        public Builder setAttendeeCount(int i) {
            this.zzaZI = i;
            this.zzaZA.add(9);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setAttendees(List<ItemScope> list) {
            this.zzaZJ = list;
            this.zzaZA.add(10);
            return this;
        }

        public Builder setAudio(ItemScope itemScope) {
            this.zzaZK = (ItemScopeEntity) itemScope;
            this.zzaZA.add(11);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setAuthor(List<ItemScope> list) {
            this.zzaZL = list;
            this.zzaZA.add(12);
            return this;
        }

        public Builder setBestRating(String str) {
            this.zzaZM = str;
            this.zzaZA.add(13);
            return this;
        }

        public Builder setBirthDate(String str) {
            this.zzaZN = str;
            this.zzaZA.add(14);
            return this;
        }

        public Builder setByArtist(ItemScope itemScope) {
            this.zzaZO = (ItemScopeEntity) itemScope;
            this.zzaZA.add(15);
            return this;
        }

        public Builder setCaption(String str) {
            this.zzaZP = str;
            this.zzaZA.add(16);
            return this;
        }

        public Builder setContentSize(String str) {
            this.zzaZQ = str;
            this.zzaZA.add(17);
            return this;
        }

        public Builder setContentUrl(String str) {
            this.zztN = str;
            this.zzaZA.add(18);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setContributor(List<ItemScope> list) {
            this.zzaZR = list;
            this.zzaZA.add(19);
            return this;
        }

        public Builder setDateCreated(String str) {
            this.zzaZS = str;
            this.zzaZA.add(20);
            return this;
        }

        public Builder setDateModified(String str) {
            this.zzaZT = str;
            this.zzaZA.add(21);
            return this;
        }

        public Builder setDatePublished(String str) {
            this.zzaZU = str;
            this.zzaZA.add(22);
            return this;
        }

        public Builder setDescription(String str) {
            this.zzavc = str;
            this.zzaZA.add(23);
            return this;
        }

        public Builder setDuration(String str) {
            this.zzaZV = str;
            this.zzaZA.add(24);
            return this;
        }

        public Builder setEmbedUrl(String str) {
            this.zzaZW = str;
            this.zzaZA.add(25);
            return this;
        }

        public Builder setEndDate(String str) {
            this.zzaZX = str;
            this.zzaZA.add(26);
            return this;
        }

        public Builder setFamilyName(String str) {
            this.zzaZY = str;
            this.zzaZA.add(27);
            return this;
        }

        public Builder setGender(String str) {
            this.zzaZZ = str;
            this.zzaZA.add(28);
            return this;
        }

        public Builder setGeo(ItemScope itemScope) {
            this.zzbaa = (ItemScopeEntity) itemScope;
            this.zzaZA.add(29);
            return this;
        }

        public Builder setGivenName(String str) {
            this.zzbab = str;
            this.zzaZA.add(30);
            return this;
        }

        public Builder setHeight(String str) {
            this.zzbac = str;
            this.zzaZA.add(31);
            return this;
        }

        public Builder setId(String str) {
            this.zzxX = str;
            this.zzaZA.add(32);
            return this;
        }

        public Builder setImage(String str) {
            this.zzbad = str;
            this.zzaZA.add(33);
            return this;
        }

        public Builder setInAlbum(ItemScope itemScope) {
            this.zzbae = (ItemScopeEntity) itemScope;
            this.zzaZA.add(34);
            return this;
        }

        public Builder setLatitude(double d2) {
            this.zzaKR = d2;
            this.zzaZA.add(36);
            return this;
        }

        public Builder setLocation(ItemScope itemScope) {
            this.zzbaf = (ItemScopeEntity) itemScope;
            this.zzaZA.add(37);
            return this;
        }

        public Builder setLongitude(double d2) {
            this.zzaKS = d2;
            this.zzaZA.add(38);
            return this;
        }

        public Builder setName(String str) {
            this.mName = str;
            this.zzaZA.add(39);
            return this;
        }

        public Builder setPartOfTVSeries(ItemScope itemScope) {
            this.zzbag = (ItemScopeEntity) itemScope;
            this.zzaZA.add(40);
            return this;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public Builder setPerformers(List<ItemScope> list) {
            this.zzbah = list;
            this.zzaZA.add(41);
            return this;
        }

        public Builder setPlayerType(String str) {
            this.zzbai = str;
            this.zzaZA.add(42);
            return this;
        }

        public Builder setPostOfficeBoxNumber(String str) {
            this.zzbaj = str;
            this.zzaZA.add(43);
            return this;
        }

        public Builder setPostalCode(String str) {
            this.zzbak = str;
            this.zzaZA.add(44);
            return this;
        }

        public Builder setRatingValue(String str) {
            this.zzbal = str;
            this.zzaZA.add(45);
            return this;
        }

        public Builder setReviewRating(ItemScope itemScope) {
            this.zzbam = (ItemScopeEntity) itemScope;
            this.zzaZA.add(46);
            return this;
        }

        public Builder setStartDate(String str) {
            this.zzban = str;
            this.zzaZA.add(47);
            return this;
        }

        public Builder setStreetAddress(String str) {
            this.zzbao = str;
            this.zzaZA.add(48);
            return this;
        }

        public Builder setText(String str) {
            this.zzbap = str;
            this.zzaZA.add(49);
            return this;
        }

        public Builder setThumbnail(ItemScope itemScope) {
            this.zzbaq = (ItemScopeEntity) itemScope;
            this.zzaZA.add(50);
            return this;
        }

        public Builder setThumbnailUrl(String str) {
            this.zzbar = str;
            this.zzaZA.add(51);
            return this;
        }

        public Builder setTickerSymbol(String str) {
            this.zzbas = str;
            this.zzaZA.add(52);
            return this;
        }

        public Builder setType(String str) {
            this.zzIx = str;
            this.zzaZA.add(53);
            return this;
        }

        public Builder setUrl(String str) {
            this.zzF = str;
            this.zzaZA.add(54);
            return this;
        }

        public Builder setWidth(String str) {
            this.zzbat = str;
            this.zzaZA.add(55);
            return this;
        }

        public Builder setWorstRating(String str) {
            this.zzbau = str;
            this.zzaZA.add(56);
            return this;
        }
    }

    ItemScope getAbout();

    List<String> getAdditionalName();

    ItemScope getAddress();

    String getAddressCountry();

    String getAddressLocality();

    String getAddressRegion();

    List<ItemScope> getAssociated_media();

    int getAttendeeCount();

    List<ItemScope> getAttendees();

    ItemScope getAudio();

    List<ItemScope> getAuthor();

    String getBestRating();

    String getBirthDate();

    ItemScope getByArtist();

    String getCaption();

    String getContentSize();

    String getContentUrl();

    List<ItemScope> getContributor();

    String getDateCreated();

    String getDateModified();

    String getDatePublished();

    String getDescription();

    String getDuration();

    String getEmbedUrl();

    String getEndDate();

    String getFamilyName();

    String getGender();

    ItemScope getGeo();

    String getGivenName();

    String getHeight();

    String getId();

    String getImage();

    ItemScope getInAlbum();

    double getLatitude();

    ItemScope getLocation();

    double getLongitude();

    String getName();

    ItemScope getPartOfTVSeries();

    List<ItemScope> getPerformers();

    String getPlayerType();

    String getPostOfficeBoxNumber();

    String getPostalCode();

    String getRatingValue();

    ItemScope getReviewRating();

    String getStartDate();

    String getStreetAddress();

    String getText();

    ItemScope getThumbnail();

    String getThumbnailUrl();

    String getTickerSymbol();

    String getType();

    String getUrl();

    String getWidth();

    String getWorstRating();

    boolean hasAbout();

    boolean hasAdditionalName();

    boolean hasAddress();

    boolean hasAddressCountry();

    boolean hasAddressLocality();

    boolean hasAddressRegion();

    boolean hasAssociated_media();

    boolean hasAttendeeCount();

    boolean hasAttendees();

    boolean hasAudio();

    boolean hasAuthor();

    boolean hasBestRating();

    boolean hasBirthDate();

    boolean hasByArtist();

    boolean hasCaption();

    boolean hasContentSize();

    boolean hasContentUrl();

    boolean hasContributor();

    boolean hasDateCreated();

    boolean hasDateModified();

    boolean hasDatePublished();

    boolean hasDescription();

    boolean hasDuration();

    boolean hasEmbedUrl();

    boolean hasEndDate();

    boolean hasFamilyName();

    boolean hasGender();

    boolean hasGeo();

    boolean hasGivenName();

    boolean hasHeight();

    boolean hasId();

    boolean hasImage();

    boolean hasInAlbum();

    boolean hasLatitude();

    boolean hasLocation();

    boolean hasLongitude();

    boolean hasName();

    boolean hasPartOfTVSeries();

    boolean hasPerformers();

    boolean hasPlayerType();

    boolean hasPostOfficeBoxNumber();

    boolean hasPostalCode();

    boolean hasRatingValue();

    boolean hasReviewRating();

    boolean hasStartDate();

    boolean hasStreetAddress();

    boolean hasText();

    boolean hasThumbnail();

    boolean hasThumbnailUrl();

    boolean hasTickerSymbol();

    boolean hasType();

    boolean hasUrl();

    boolean hasWidth();

    boolean hasWorstRating();
}
