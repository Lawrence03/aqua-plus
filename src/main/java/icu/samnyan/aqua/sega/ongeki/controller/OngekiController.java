package icu.samnyan.aqua.sega.ongeki.controller;


import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.ongeki.handler.impl.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@RestController
@RequestMapping("OngekiServlet")
public class OngekiController {

    private final GetGameEventHandler getGameEventHandler;
    private final GetGameIdlistHandler getGameIdlistHandler;
    private final GetGameMessageHandler getGameMessageHandler;
    private final GetGamePointHandler getGamePointHandler;
    private final GetGamePresentHandler getGamePresentHandler;
    private final GetGameRankingHandler getGameRankingHandler;
    private final GetGameRewardHandler getGameRewardHandler;
    private final GetGameSettingHandler getGameSettingHandler;
    private final GetGameTechMusicHandler getGameTechMusicHandler;
    private final GetUserActivityHandler getUserActivityHandler;
    private final GetUserBossHandler getUserBossHandler;
    private final GetUserBpBaseHandler getUserBpBaseHandler;
    private final GetUserCardHandler getUserCardHandler;
    private final GetUserChapterHandler getUserChapterHandler;
    private final GetUserCharacterHandler getUserCharacterHandler;
    private final GetUserDataHandler getUserDataHandler;
    private final GetUserDeckByKeyHandler getUserDeckByKeyHandler;
    private final GetUserEventPointHandler getUserEventPointHandler;
    private final GetUserEventRankingHandler getUserEventRankingHandler;
    private final GetUserItemHandler getUserItemHandler;
    private final GetUserLoginBonusHandler getUserLoginBonusHandler;
    private final GetUserMissionPointHandler getUserMissionPointHandler;
    private final GetUserMusicHandler getUserMusicHandler;
    private final GetUserMusicItemHandler getUserMusicItemHandler;
    private final GetUserOptionHandler getUserOptionHandler;
    private final GetUserPreviewHandler getUserPreviewHandler;
    private final GetUserRatinglogListHandler getUserRatinglogListHandler;
    private final GetUserRecentRatingHandler getUserRecentRatingHandler;
    private final GetUserRegionHandler getUserRegionHandler;
    private final GetUserScenarioHandler getUserScenarioHandler;
    private final GetUserStoryHandler getUserStoryHandler;
    private final GetUserTechCountHandler getUserTechCountHandler;
    private final GetUserTrainingRoomByKeyHandler getUserTrainingRoomByKeyHandler;
    private final UpsertUserAllHandler upsertUserAllHandler;
    private final GetUserTradeItemHandler getUserTradeItemHandler;
    private final GetUserEventMusicHandler getUserEventMusicHandler;
    private final GetUserTechEventHandler getUserTechEventHandler;
    private final GetUserTechEventRankingHandler getUserTechEventRankingHandler;
    private final GetUserKopHandler getUserKopHandler;

    @Autowired
    public OngekiController(GetGameEventHandler getGameEventHandler, GetGameIdlistHandler getGameIdlistHandler, GetGameMessageHandler getGameMessageHandler, GetGamePointHandler getGamePointHandler, GetGamePresentHandler getGamePresentHandler, GetGameRankingHandler getGameRankingHandler, GetGameRewardHandler getGameRewardHandler, GetGameSettingHandler getGameSettingHandler, GetGameTechMusicHandler getGameTechMusicHandler, GetUserActivityHandler getUserActivityHandler, GetUserBossHandler getUserBossHandler, GetUserBpBaseHandler getUserBpBaseHandler, GetUserCardHandler getUserCardHandler, GetUserChapterHandler getUserChapterHandler, GetUserCharacterHandler getUserCharacterHandler, GetUserDataHandler getUserDataHandler, GetUserDeckByKeyHandler getUserDeckByKeyHandler, GetUserEventPointHandler getUserEventPointHandler, GetUserEventRankingHandler getUserEventRankingHandler, GetUserItemHandler getUserItemHandler, GetUserLoginBonusHandler getUserLoginBonusHandler, GetUserMissionPointHandler getUserMissionPointHandler, GetUserMusicHandler getUserMusicHandler, GetUserMusicItemHandler getUserMusicItemHandler, GetUserOptionHandler getUserOptionHandler, GetUserPreviewHandler getUserPreviewHandler, GetUserRatinglogListHandler getUserRatinglogListHandler, GetUserRecentRatingHandler getUserRecentRatingHandler, GetUserRegionHandler getUserRegionHandler, GetUserScenarioHandler getUserScenarioHandler, GetUserStoryHandler getUserStoryHandler, GetUserTechCountHandler getUserTechCountHandler, GetUserTrainingRoomByKeyHandler getUserTrainingRoomByKeyHandler, UpsertUserAllHandler upsertUserAllHandler, GetUserTradeItemHandler getUserTradeItemHandler, GetUserEventMusicHandler getUserEventMusicHandler, GetUserTechEventHandler getUserTechEventHandler, GetUserTechEventRankingHandler getUserTechEventRankingHandler, GetUserKopHandler getUserKopHandler) {
        this.getGameEventHandler = getGameEventHandler;
        this.getGameIdlistHandler = getGameIdlistHandler;
        this.getGameMessageHandler = getGameMessageHandler;
        this.getGamePointHandler = getGamePointHandler;
        this.getGamePresentHandler = getGamePresentHandler;
        this.getGameRankingHandler = getGameRankingHandler;
        this.getGameRewardHandler = getGameRewardHandler;
        this.getGameSettingHandler = getGameSettingHandler;
        this.getGameTechMusicHandler = getGameTechMusicHandler;
        this.getUserActivityHandler = getUserActivityHandler;
        this.getUserBossHandler = getUserBossHandler;
        this.getUserBpBaseHandler = getUserBpBaseHandler;
        this.getUserCardHandler = getUserCardHandler;
        this.getUserChapterHandler = getUserChapterHandler;
        this.getUserCharacterHandler = getUserCharacterHandler;
        this.getUserDataHandler = getUserDataHandler;
        this.getUserDeckByKeyHandler = getUserDeckByKeyHandler;
        this.getUserEventPointHandler = getUserEventPointHandler;
        this.getUserEventRankingHandler = getUserEventRankingHandler;
        this.getUserItemHandler = getUserItemHandler;
        this.getUserLoginBonusHandler = getUserLoginBonusHandler;
        this.getUserMissionPointHandler = getUserMissionPointHandler;
        this.getUserMusicHandler = getUserMusicHandler;
        this.getUserMusicItemHandler = getUserMusicItemHandler;
        this.getUserOptionHandler = getUserOptionHandler;
        this.getUserPreviewHandler = getUserPreviewHandler;
        this.getUserRatinglogListHandler = getUserRatinglogListHandler;
        this.getUserRecentRatingHandler = getUserRecentRatingHandler;
        this.getUserRegionHandler = getUserRegionHandler;
        this.getUserScenarioHandler = getUserScenarioHandler;
        this.getUserStoryHandler = getUserStoryHandler;
        this.getUserTechCountHandler = getUserTechCountHandler;
        this.getUserTrainingRoomByKeyHandler = getUserTrainingRoomByKeyHandler;
        this.upsertUserAllHandler = upsertUserAllHandler;
        this.getUserTradeItemHandler = getUserTradeItemHandler;
        this.getUserEventMusicHandler = getUserEventMusicHandler;
        this.getUserTechEventHandler = getUserTechEventHandler;
        this.getUserTechEventRankingHandler = getUserTechEventRankingHandler;
        this.getUserKopHandler = getUserKopHandler;
    }

    @PostMapping(value = {"ExtendLockTimeApi", "13DAEC4A57E02CEA3804C46C2245912C", "16DA30C41A82286165CC7AFD0952F9BE"})
    public String extendLockTime(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":1,\"apiName\":\"extendLockTime\"}";
    }

    @PostMapping(value = {"GameLoginApi", "2D399F7A611ABEB653EF42FDCE9DD102", "E4C8C67C882CB6369BB82CB4A4483B4B"})
    public String gameLogin(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":1,\"apiName\":\"gameLogin\"}";
    }

    @PostMapping(value = {"GameLogoutApi", "A15953681ACA00955598706A612A2DFE", "841DC36210D3347DB9071EC358598EF7"})
    public String gameLogout(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":1,\"apiName\": \"gameLogout\"}";
    }

    @PostMapping(value = {"GetGameEventApi", "A1CBD12F613E284F3F15725FB551B3CD", "DE94957591AB74708EA30C6BAE0DA595"})
    public String getGameEvent(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameEventHandler.handle(request);
    }

    @PostMapping(value = {"GetGameIdlistApi", "68F05ACB4CE6B71A15F8B9DFEF280930", "89A69DDECADAF52197CB0517AD00A9E5"})
    public String getGameIdList(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameIdlistHandler.handle(request);
    }

    @PostMapping(value = {"GetGameMessageApi", "F3929373A9B4EBF315B812316A1F9274", "703B411E37F56783A9A1E94562964F81"})
    public String getGameMessage(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameMessageHandler.handle(request);
    }

    @PostMapping(value = {"GetGamePointApi", "306A93F120D32F1757597472BE999906", "8E5686C7AB14404FDBC0BA0020BC332B"})
    public String getGamePoint(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGamePointHandler.handle(request);
    }

    @PostMapping(value = {"GetGamePresentApi", "4EAF714F1CEBA469740604F0B0B705BD", "56CCDA65B8674656FFF05A50994662B5"})
    public String getGamePresent(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGamePresentHandler.handle(request);
    }

    @PostMapping(value = {"GetGameRankingApi", "2E339976C25AD2612ECB5DA2BBFF1BD4", "B5505AA2FAEC12B05E6E82AE57DB32E9"})
    public String getGameRanking(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameRankingHandler.handle(request);
    }

    @PostMapping(value = {"GetGameRewardApi", "6E749251F7ECA96366DA5790D32A0AA0", "DA81BCB90CFBA60E9AA7D08AE101C2E6"})
    public String getGameReward(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameRewardHandler.handle(request);
    }

    @PostMapping(value = {"GetGameSettingApi", "1158610839D6B11EB42E046ED95A684D", "616C8E79436E4958CAD0F7DE6CE62D08"})
    public String getGameSetting(@ModelAttribute Map<String, Object> request, @RequestHeader("User-Agent") String userAgent, @RequestHeader(value = "Ongeki-Encoding", required = false) String ogkEncoding) throws JsonProcessingException {
        if (ogkEncoding != null && ogkEncoding.equals("120")) {
            request.put("__userAgent", userAgent);
        }
        return getGameSettingHandler.handle(request);
    }

    @PostMapping(value = {"GetUserActivityApi", "CBC1318CA8F44BC5B0E006B28DEC6EB7", "E0B7E7A998C51BD234690EB9D0EB7468"})
    public String getUserActivity(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserActivityHandler.handle(request);
    }

    @PostMapping(value = {"GetUserBossApi", "489CCECEADFE41591AA62BEEFD322CBB", "0C9B620DAB7C8C6624445795DF1E9CD8"})
    public String getUserBoss(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserBossHandler.handle(request);
    }

    @PostMapping(value = {"GetUserBpBaseApi", "1A2CCFA5BBC7960152AAAB201A47F0A4", "E98720425759D4FB8EF21EE6F02F285B"})
    public String getUserBpBase(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserBpBaseHandler.handle(request);
    }

    @PostMapping(value = {"GetUserCardApi", "DBD2BF1288D0A1174E99AC56199D8281", "7290F3C63B76206045EB18767AAFEBD9"})
    public String getUserCard(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserCardHandler.handle(request);
    }
    @PostMapping(value = {"GetUserChapterApi", "7DDDF80DCC17D999BA7283D818F06884", "50B7D76BF2CE46BED2318F81BE86C715"})
    public String getUserChapter(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserChapterHandler.handle(request);
    }

    @PostMapping(value = {"GetUserCharacterApi", "CD59A56D34181A6556CC10E173F25357", "C3F086C09A33E7D15EF76E6745152B90"})
    public String getUserCharacter(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserCharacterHandler.handle(request);
    }

    @PostMapping(value = {"GetUserDataApi", "8B6BE731BFBD8E5CFE7B2DDFC8EC53A2", "666EA2BD60DA011B89D1B7FCD098A177"})
    public String getUserData(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserDataHandler.handle(request);
    }

    @PostMapping(value = {"GetUserDeckByKeyApi", "EF5642E479B2C9115F9C432B7A1E2A30", "21B49EB09048B7137E7A2C5F5F2884D0"})
    public String getUserDeckByKey(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserDeckByKeyHandler.handle(request);
    }

    @PostMapping(value = {"GetUserEventPointApi", "96CBEE2A290BF6C0ED106AE12BBC6419", "E1D8DD12D741671D655BE8C67CC812F3"})
    public String getUserEventPoint(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserEventPointHandler.handle(request);
    }

    @PostMapping(value = {"GetUserEventRankingApi", "520E4A593AA5E8EDA2B535B1553A975E", "2852E2674D35ABFFD5E91D264A8DFD3B"})
    public String getUserEventRanking(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserEventRankingHandler.handle(request);
    }

    @PostMapping(value = {"GetUserItemApi", "09A8AEBD577187A674ABB2E945E20EC1", "801BDAEC73018178081A5AAA4E3E9647"})
    public String getUserItem(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserItemHandler.handle(request);
    }

    @PostMapping(value = {"GetUserLoginBonusApi", "42913DA9076EA8EF5D78FE5FDFACB955", "3EE394B54F0EF17624FAEE8ED32E4AC0"})
    public String getUserLoginBonus(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserLoginBonusHandler.handle(request);
    }

    @PostMapping(value = {"GetUserMissionPointApi", "78597CDDB8BEBD6E6EDD98D4CE7C3E45", "302E954067157D155CDC44BFA1DD7815"})
    public String getUserMissionPoint(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserMissionPointHandler.handle(request);
    }

    @PostMapping(value = {"GetUserMusicApi", "BD16E726C9B3E1D985922CF951BC8E0D", "041CC5C528688809EE2701B3E371A2AC"})
    public String getUserMusic(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserMusicHandler.handle(request);
    }

    @PostMapping(value = {"GetUserMusicItemApi", "9E9A55F7DF9EF7FAEE060497F6856EE1", "21190EEC45AC07BCAB8730D22637809F"})
    public String getUserMusicItem(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserMusicItemHandler.handle(request);
    }

    @PostMapping(value = {"GetUserOptionApi", "F35222721356BA6CEB405278D9F16417", "A572FA51F15685BF70615826BFE776AC"})
    public String getUserOption(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserOptionHandler.handle(request);
    }

    @PostMapping(value = {"GetUserPreviewApi", "F8C58EF7BD9E62EA795CCF625E208547", "DF539B786277B0EEDE8BD1D574FEC082"})
    public String getUserPreview(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserPreviewHandler.handle(request);
    }

    @PostMapping(value = {"GetUserRatinglogApi", "EC11F65B9E17B7C9D95FE8B8FCD92739", "3374F8F7299D1980B3458203F830B4BA"})
    public String getUserRatinglog(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRatinglogListHandler.handle(request);
    }

    @PostMapping(value = {"GetUserRecentRatingApi", "A95A36769B64768DB8909DE972C0D090", "708482A16F0AA94EBB7EF3C7BC430F85"})
    public String getUserRecentRating(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRecentRatingHandler.handle(request);
    }

    @PostMapping(value = {"GetUserRegionApi", "B9981CB44C8413117E5DD06FB8284236", "416633853A077F804B0F395A149D8FEA"})
    public String getUserRegion(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRegionHandler.handle(request);
    }

    @PostMapping(value = {"GetUserScenarioApi", "A68DB79241AD8F55CB13F589E46FB0A2", "385736CC09863F12E57B91983229B25D"})
    public String getUserScenario(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserScenarioHandler.handle(request);
    }

    @PostMapping(value = {"GetUserStoryApi", "CDD08F9A63A3ACFC9831F0292969BBFE", "08596C946A232D5F86FAC3DD1564D1CC"})
    public String getUserStory(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserStoryHandler.handle(request);
    }

    @PostMapping(value = {"GetUserTechCountApi", "72B1A192B96BCC3351B274BE062DFA4B", "D9787BDFCBDFE4C463A4AC48D01CE3B5"})
    public String getUserTechCount(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserTechCountHandler.handle(request);
    }

    @PostMapping(value = {"GetUserTrainingRoomByKeyApi", "EC181A743CA06F487ACFFF923B308B5F", "5B873275647AD73BCBB643EDF549FE20"})
    public String getUserTrainingRoomByKey(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserTrainingRoomByKeyHandler.handle(request);
    }

    @PostMapping(value = {"UpsertClientBookkeepingApi", "55D43A27DDF653604CC2EDAC81EE64BD", "BB55D6AE7DD67E772BC250544DD6F8D8"})
    public String upsertClientBookkeeping(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":1},\"apiName\":\"upsertClientBookkeeping\"";
    }

    @PostMapping(value = {"UpsertClientDevelopApi", "F2117DA883BEE2A35E10A8F74937311B", "BF85D22E0365D9B7A0B3A7B3331A562E"})
    public String upsertClientDevelop(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":1},\"apiName\":\"upsertClientDevelop\"";
    }

    @PostMapping(value = {"UpsertClientErrorApi", "31D37ACDAD33E4A5811002A2ACCFE0EA", "5AD5FAF247B2862385A1A6D4713BB53F"})
    public String upsertClientError(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":1,\"apiName\":\"upsertClientError\"}";
    }

    @PostMapping(value = {"UpsertClientSettingApi", "E3892BEA9A2E834BE262248BACCA3132", "6B9A3A5CE30D36028F71F8596AF30946"})
    public String upsertClientSetting(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":1,\"apiName\":\"upsertClientSetting\"}";
    }

    @PostMapping(value = {"UpsertClientTestmodeApi", "3F49912C1DFBCCED19AB8D0AD30068AC", "8FEE7DAB104E7008078A1F43431F231F"})
    public String upsertClientTestmode(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":1,\"apiName\":\"upsertClientTestmode\"}";
    }

    @PostMapping(value = {"UpsertUserGplogApi", "56557BE453C4BCB9F52E26E63F5AE125", "758F3E2B5C75601441958CB3E21AEF68"})
    public String upsertUserGplog(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":1,\"apiName\":\"upsertUserGplog\"}";
    }

    @PostMapping(value = {"UpsertUserAllApi", "47048030C0CBFAD342223BE240040B7B", "DC5D14BD883FE0A3C1BFD1807D36DEFD"})
    public String upsertUserAll(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertUserAllHandler.handle(request);
    }
    
    @PostMapping(value = {"GetGameTechMusicApi", "6F7EF5666E7CCA2D9227CDA5C800126D", "28505CB356849ACE9A59169E3D394A55"})
    public String getGameTechMusic(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameTechMusicHandler.handle(request);
    }

    @PostMapping(value = {"GetUserTradeItemApi", "918FE7759CFC9ECC55B5A615BF68B32D", "6C40718BA6E4C0975D192691E41BE92C"})
    public String getUserTradeItem(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserTradeItemHandler.handle(request);
    }

    @PostMapping(value = {"GetUserEventMusicApi", "C7783F74BA27796623FCAD1FB8D6AB96", "FF609058FC2529C20A7F8F61BA9C0583"})
    public String getUserEventMusic(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserEventMusicHandler.handle(request);
    }

    @PostMapping(value = {"GetUserTechEventApi", "E838E6B7E16B472A67817F4180559ABA", "E2A0A1B5349AA1362A750A5B0E3424EE"})
    public String getUserTechEvent(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserTechEventHandler.handle(request);
    }

    @PostMapping(value = {"GetUserTechEventRankingApi", "2617D9F6B9DF94E8983975ECACE7DD11", "0C971009915AD4E2EB02183928045A12"})
    public String getUserTechEventRanking(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserTechEventRankingHandler.handle(request);
    }

    @PostMapping(value = {"GetUserKopApi", "DDFAC60C2EFA0EA79F61BC9224FC412E", "DAE8F5D3646920684169228395378D2E"})
    public String getUserKop(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserKopHandler.handle(request);
    }
}
