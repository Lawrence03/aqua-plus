package icu.samnyan.aqua.sega.mai2.controller;

import com.fasterxml.jackson.core.JsonProcessingException;
import icu.samnyan.aqua.sega.mai2.handler.impl.*;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

/**
 * @author samnyan (privateamusement@protonmail.com)
 */
@RestController
@RequestMapping("Maimai2Servlet")
public class Maimai2ServletController {

    private final GetGameChargeHandler getGameChargeHandler;
    private final GetGameEventHandler getGameEventHandler;
    private final GetGameRankingHandler getGameRankingHandler;
    private final GetGameSettingHandler getGameSettingHandler;
    private final GetGameTournamentInfoHandler getGameTournamentInfoHandler;
    private final GetUserActivityHandler getUserActivityHandler;
    private final GetUserCardHandler getUserCardHandler;
    private final GetUserChargeHandler getUserChargeHandler;
    private final GetUserCharacterHandler getUserCharacterHandler;
    private final GetUserCourseHandler getUserCourseHandler;
    private final GetUserDataHandler getUserDataHandler;
    private final GetUserExtendHandler getUserExtendHandler;
    private final GetUserFavoriteHandler getUserFavoriteHandler;
    private final GetUserGhostHandler getUserGhostHandler;
    private final GetUserItemHandler getUserItemHandler;
    private final GetUserLoginBonusHandler getUserLoginBonusHandler;
    private final GetUserMapHandler getUserMapHandler;
    private final GetUserMusicHandler getUserMusicHandler;
    private final GetUserOptionHandler getUserOptionHandler;
    private final GetUserPortraitHandler getUserPortraitHandler;
    private final GetUserPreviewHandler getUserPreviewHandler;
    private final GetUserRatingHandler getUserRatingHandler;
    private final GetUserRegionHandler getUserRegionHandler;
    private final UploadUserPhotoHandler uploadUserPhotoHandler;
    private final UploadUserPlaylogHandler uploadUserPlaylogHandler;
    private final UploadUserPortraitHandler uploadUserPortraitHandler;
    private final UpsertUserAllHandler upsertUserAllHandler;
    private final UserLoginHandler userLoginHandler;
    private final UserLogoutHandler userLogoutHandler;
    private final GetGameNgMusicIdHandler getGameNgMusicIdHandler;
    private final GetUserFriendSeasonRankingHandler getUserFriendSeasonRankingHandler;

    public Maimai2ServletController(GetGameNgMusicIdHandler getGameNgMusicIdHandler, GetUserFriendSeasonRankingHandler getUserFriendSeasonRankingHandler, GetGameChargeHandler getGameChargeHandler, GetGameEventHandler getGameEventHandler, GetGameRankingHandler getGameRankingHandler, GetGameSettingHandler getGameSettingHandler, GetGameTournamentInfoHandler getGameTournamentInfoHandler, GetUserActivityHandler getUserActivityHandler, GetUserCardHandler getUserCardHandler, GetUserChargeHandler getUserChargeHandler, GetUserCharacterHandler getUserCharacterHandler, GetUserCourseHandler getUserCourseHandler, GetUserDataHandler getUserDataHandler, GetUserExtendHandler getUserExtendHandler, GetUserFavoriteHandler getUserFavoriteHandler, GetUserGhostHandler getUserGhostHandler, GetUserItemHandler getUserItemHandler, GetUserLoginBonusHandler getUserLoginBonusHandler, GetUserMapHandler getUserMapHandler, GetUserMusicHandler getUserMusicHandler, GetUserOptionHandler getUserOptionHandler, GetUserPortraitHandler getUserPortraitHandler, GetUserPreviewHandler getUserPreviewHandler, GetUserRatingHandler getUserRatingHandler, GetUserRegionHandler getUserRegionHandler, UploadUserPhotoHandler uploadUserPhotoHandler, UploadUserPlaylogHandler uploadUserPlaylogHandler, UploadUserPortraitHandler uploadUserPortraitHandler, UpsertUserAllHandler upsertUserAllHandler, UserLoginHandler userLoginHandler, UserLogoutHandler userLogoutHandler) {
        this.getGameChargeHandler = getGameChargeHandler;
        this.getGameNgMusicIdHandler = getGameNgMusicIdHandler;
        this.getUserFriendSeasonRankingHandler = getUserFriendSeasonRankingHandler;
        this.getGameEventHandler = getGameEventHandler;
        this.getGameRankingHandler = getGameRankingHandler;
        this.getGameSettingHandler = getGameSettingHandler;
        this.getGameTournamentInfoHandler = getGameTournamentInfoHandler;
        this.getUserActivityHandler = getUserActivityHandler;
        this.getUserCardHandler = getUserCardHandler;
        this.getUserChargeHandler = getUserChargeHandler;
        this.getUserCharacterHandler = getUserCharacterHandler;
        this.getUserCourseHandler = getUserCourseHandler;
        this.getUserDataHandler = getUserDataHandler;
        this.getUserExtendHandler = getUserExtendHandler;
        this.getUserFavoriteHandler = getUserFavoriteHandler;
        this.getUserGhostHandler = getUserGhostHandler;
        this.getUserItemHandler = getUserItemHandler;
        this.getUserLoginBonusHandler = getUserLoginBonusHandler;
        this.getUserMapHandler = getUserMapHandler;
        this.getUserMusicHandler = getUserMusicHandler;
        this.getUserOptionHandler = getUserOptionHandler;
        this.getUserPortraitHandler = getUserPortraitHandler;
        this.getUserPreviewHandler = getUserPreviewHandler;
        this.getUserRatingHandler = getUserRatingHandler;
        this.getUserRegionHandler = getUserRegionHandler;
        this.uploadUserPhotoHandler = uploadUserPhotoHandler;
        this.uploadUserPlaylogHandler = uploadUserPlaylogHandler;
        this.uploadUserPortraitHandler = uploadUserPortraitHandler;
        this.upsertUserAllHandler = upsertUserAllHandler;
        this.userLoginHandler = userLoginHandler;
        this.userLogoutHandler = userLogoutHandler;
    }


    @PostMapping(value = {"GetGameSettingApi", "518a97faae9b4a3e1a584697cbf0ece5", "2ea503a829828346b756b4f3581218b2", "f72c03c3284f3e1b3ff72409be840271", "e025544a689dea5868cd946efa24703a"})
    public String getGameSettingApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameSettingHandler.handle(request);
    }

    @PostMapping(value = {"SetGameRankingApi"})
    public String setGameRankingApi(@ModelAttribute Map<String, Object> request) {
        java.nio.file.Path path = java.nio.file.FileSystems.getDefault().getPath("gameRankingObject.json");
        try {
            icu.samnyan.aqua.sega.util.jackson.BasicMapper mapper = new icu.samnyan.aqua.sega.util.jackson.BasicMapper();
            String json = mapper.write(request);
            java.nio.file.Files.writeString(path, json);
        } catch (java.io.IOException e) {}
        return "{\"returnCode\":\"1\",\"apiName\":\"SetGameRankingApi\"}";
    }

    @PostMapping(value = {"GetGameRankingApi", "84d108c202da73c82b3b7721519aee45", "192a36b25a50636bc7016fce3b8bf6df", "ded97e28636b1ca780dbd25d6f511df1", "3f10c39ffccf79a01118a33643ce44b7"})
    public String getGameRankingApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameRankingHandler.handle(request);
    }

    @PostMapping(value = {"GetGameEventApi", "6d07d691d6545e4424feb72f58f08417", "0280e166ae1eaa0138a91e9eb6721382", "9b9e04a7b2514377c2909f1f26b39e29", "2a9aa42067978f797a5e882ed2c0fc9b"})
    public String getGameEventApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameEventHandler.handle(request);
    }

    @PostMapping(value = {"GetGameTournamentInfoApi", "c92daadb931fa896caa1805d9baef029", "4b01b4d2b9635bc2a84e7fc495c2c65c"})
    public String getGameTournamentInfoApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameTournamentInfoHandler.handle(request);
    }

    @PostMapping(value = {"GetGameChargeApi", "c4bd56fe009f8f886c1e635dd8468fb0"})
    public String getGameChargeApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameChargeHandler.handle(request);
    }

    @PostMapping(value = {"GetGameNgMusicIdApi"})
    public String getGameNgMusicIdApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getGameNgMusicIdHandler.handle(request);
    }

    @PostMapping(value = {"GetTransferFriendApi", "797d1c5b49820583bb37d12d7c76b973", "93c1d991b06af71096137559442999b5"})
    public String getTransferFriendApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return "{\"returnCode\":\"1\",\"apiName\":\"GetTransferFriendApi\"}";
    }

    @PostMapping(value = {"GetUserActivityApi", "0bccda4fd56c1db8218f350e811c3f0f", "2f7fbee39f369c5adb6aafbcb46ede10", "3cfc556d90da54c1f97d0260f6e83e08", "50608237f02ea4666a4212cae24a2b9d"})
    public String getUserActivityApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserActivityHandler.handle(request);
    }

    @PostMapping(value = {"GetUserCardApi", "a4babc0618b08cdefed1be1dca131ed9", "ffc1e4d28c297f2f68be41e15e3da01a", "4defa4241bf57231679b90f270e6e23f", "1aef202c9db3d642e25c9ca1c2577bc1"})
    public String getUserCardApi(@ModelAttribute Map<String, Object> request, @PathVariable(required = false) String ROM_VERSION) throws JsonProcessingException {
        if (ROM_VERSION != null) {
            request.put("__romVersion", ROM_VERSION);
        }
        return getUserCardHandler.handle(request);
    }

    @PostMapping(value = {"GetUserChargeApi", "b9f427a87b756b7a473d6384bfb400cc"})
    public String getUserChargeApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserChargeHandler.handle(request);
    }

    @PostMapping(value = {"GetUserCharacterApi", "4f9b2e36842720ef4704153e32e7c19e", "b15fc2082144ffd66501b4809af221ac", "51e5cbad5da6a1f5e126593b5e80caa7", "a889a0db32140dbd469007f4f36e230a"})
    public String getUserCharacterApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserCharacterHandler.handle(request);
    }

    @PostMapping(value = {"GetUserCourseApi", "edce739464e813ae22a2c1fb02d80bee"})
    public String getUserCourseApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserCourseHandler.handle(request);
    }

    @PostMapping(value = {"GetUserDataApi", "2ac627ef98785d7bc03273994f28f3a3", "7cc96f4745e59b9c9824100209a41e34", "4086e3fc64e9fe2c79da23b8ff625f57", "9ed700a43608db28d2b8dad690052741"})
    public String getUserDataApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserDataHandler.handle(request);
    }

    @PostMapping(value = {"GetUserExtendApi", "e4378f3a909520c2acd49bf2c9e7e272", "acc27e8832c1053ba3f831effb810997", "c323d18f504f662ae7e8470ed2c3ef34", "8f1c6fc1e7c2a17fc32945823e03bbf3"})
    public String getUserExtendApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserExtendHandler.handle(request);
    }

    @PostMapping(value = {"GetUserFavoriteApi", "596e2f89924d47ec6881cc8a3dfb26c4", "421bb9391f4aeaadfa010ce0b66f059d", "3ec86fc49035f55e9612959363aa3aa3", "47268109ab1431c2da2f2a20bfe771fa"})
    public String getUserFavoriteApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserFavoriteHandler.handle(request);
    }

    @PostMapping(value = {"GetUserFriendSeasonRankingApi"})
    public String getUserFriendSeasonRankingApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserFriendSeasonRankingHandler.handle(request);
    }

    @PostMapping(value = {"GetUserGhostApi", "817d4d37849366f0ea33429c29e2d5b1", "d09be04bb2ced37f3a46e143667daf2b", "9098384014d4ffbeefa34feddea6969c", "05175839e210f2512d60bdeea62edd78"})
    public String getUserGhostApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserGhostHandler.handle(request);
    }

    @PostMapping(value = {"GetUserItemApi", "4370f45e8b488100382f17cf2e3ceb9a", "4ebb38065b1b59af5a9c7a769a01f661", "bcc83a152a6eeb8e2a5764e80c2a9149", "fa771366f0f70c4e6dc682375d79381c"})
    public String getUserItemApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserItemHandler.handle(request);
    }

    @PostMapping(value = {"GetUserLoginBonusApi", "48421af5cddb902d8d2df6e25c520baf", "7fd7af2e67a0d8dac55ccd8112183a1c","16742efc98c7cd162fd5fe15a3526594"})
    public String getUserLoginBonusApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserLoginBonusHandler.handle(request);
    }

    @PostMapping(value = {"GetUserMapApi", "827aaa502fbb40dcd5f4e471360abd52", "106894bc99c6a6cc09aaf3b5bc0050ab", "a40d93f2db157259f46f7f62ed2f8f95", "68ae32a7cc7b78a3d503193b384deebd"})
    public String getUserMapApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserMapHandler.handle(request);
    }

    @PostMapping(value = {"GetUserMusicApi", "124cd95eced641a173241dc0a8546068", "49fe8c224e0a06123af3fecfd3b68360", "1aba5767903d1c0873b9714277f6afc2", "711ff55eb7b2fbc2f554092f038ef2f2"})
    public String getUserMusicApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserMusicHandler.handle(request);
    }

    @PostMapping(value = {"GetUserOptionApi", "bde29f1923cefa04dc4cdefbea1ce293", "42bc18e5cd7f2542f51c316543fb55aa", "f7380669b0127d5bb65945842c074ad4", "8057540791b20c7a44cd04f8ec082345"})
    public String getUserOptionApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserOptionHandler.handle(request);
    }

    @PostMapping(value = {"GetUserPortraitApi", "aef3bc7b6631a5bb6d489547922bc3d7", "9ab5298f1842c926a50a6f1d9ccd28c7", "8b40b53090dd6519adfa4de500023b37", "86d92a533c959b0311e641b69b352ee9"})
    public String getUserPortraitApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserPortraitHandler.handle(request);
    }

    @PostMapping(value = {"GetUserPreviewApi", "0f5448f13ecd509c9f51c84bd83738ce", "14b7e17109120e978265445528ceec6f", "0905f791336fc70df81d12d466e2c8df", "c8ed23d49b873e0e3b1d906fa8b46f64"})
    public String getUserPreviewApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserPreviewHandler.handle(request);
    }

    @PostMapping(value = {"GetUserRatingApi", "5f4774abe379d81938b1bd87bb07eb12", "86e22f7ec929ee967f110aca28becf2e", "030bd85faca2c80bfb8748df5f814812", "4bbb2d6e1deeaee11752eeb5050db480"})
    public String getUserRatingApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRatingHandler.handle(request);
    }

    @PostMapping(value = {"GetUserRegionApi", "d50f09ca84cfc769e4590311a9f8be82", "741698a1e7b7bec17ef30d67f2b10d97", "e3b9a140106562febf1a1a80bfebb8f6", "350df96d2ed03dda7400f8e5498af447"})
    public String getUserRegionApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return getUserRegionHandler.handle(request);
    }

    @PostMapping(value = {"GetUserScoreRankingApi", "dbf3fef88ac019b69f7caa38edbdb15e", "e102c5e1c4f255d4c2c0277bfc3f984a"})
    public String getUserScoreRankingApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return "{\"returnCode\":\"1\",\"apiName\":\"GetUserScoreRankingApi\"}";
    }

    @PostMapping(value = {"UploadUserPhotoApi", "4ce379d0f441799e474d2d60599389c9", "34888cdd340c945828c42f1093b0e963", "d9c92dc241f4ae8316779aef349c84d4", "3f3fa479b95e81dbbfd379a231086744"})
    public String uploadUserPhoto(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return uploadUserPhotoHandler.handle(request);
    }

    @PostMapping(value = {"UploadUserPlaylogApi", "4b849bc7373f58a53cb19bf62e08864e", "7d6c9b1c5ec5acfd14617fbee351362e", "5d2d9d8e49ec1fa9c03041f081aa9dfb", "c6167368e1298e2beb3f1dbb2be23401"})
    public String uploadUserPlaylog(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return uploadUserPlaylogHandler.handle(request);
    }

    @PostMapping(value = {"UploadUserPortraitApi", "168238d60e0576f8c302e91643ed3344", "9c8cfd53c4cd64bf12d3c8e035bc7bc7", "119ef16e026e6fc29549cfdf47ae6686", "c9313f89a770dc5c33c301d0da34086d"})
    public String uploadUserPortrait(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return uploadUserPortraitHandler.handle(request);
    }

    @PostMapping(value = {"UpsertClientBookkeepingApi", "30240b52787bbc7caddbef61e001f828", "62a7d3a119905e705213caf14ee6657b", "cce5b295ada69bde8ef85e89a067455e", "a6fecaa832f91e7227c9d5a952439a50"})
    public String upsertClientBookkeeping(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\",\"apiName\":\"UpsertClientBookkeepingApi\"}";
    }

    @PostMapping(value = {"UpsertClientSettingApi", "ccec54b4172c2f0948e69cb2e879d4d4", "62db6cc7157fdc042d89172f1f41fc60", "02081308c0be5105d54dd0a38875135f", "64a70e06cb391bdbb3eb984bc14dc347"})
    public String upsertClientSetting(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\",\"apiName\":\"UpsertClientSettingApi\"}";
    }

    @PostMapping(value = {"UpsertClientTestmodeApi", "1e08b7138d385d55f887c2945b910757", "b554c4667796d109ff055133b32068df", "5576c689128dbe1381e324b1e024061f", "1a1a51d3dca8a4fdd518e1bcc2368863"})
    public String upsertClientTestmode(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\",\"apiName\":\"UpsertClientTestmodeApi\"}";
    }

    @PostMapping(value = {"UpsertClientUploadApi", "0ce7f5c4f89ddea839624f947dc1d917", "a46ef6c8520273215120eecad354a262", "b3c672bc0e560d45a9c0f3d53d3a2065", "7b0525dcba838df1660f3d43f49317fb"})
    public String upsertClientUpload(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\",\"apiName\":\"UpsertClientUploadApi\"}";
    }

    @PostMapping(value = {"UpsertUserChargelogApi", "0ce7f5c4f89ddea839624f947dc1d917", "a46ef6c8520273215120eecad354a262", "b3c672bc0e560d45a9c0f3d53d3a2065", "ee44001609a58f2906b29169f3df2fb6"})
    public String upsertUserChargelog(@ModelAttribute Map<String, Object> request) {
        return "{\"returnCode\":\"1\",\"apiName\":\"UpsertUserChargelogApi\"}";
    }

    @PostMapping(value = {"UpsertUserAllApi", "e2222c4e05c32c2fc69286d3867d42e9", "1c508614d3be7ee2ddfe0732b4c4be59", "10c41f5e09382cb54551d7deefb7c293", "186d448515fd5d9318d29091dedd719c"})
    public String upsertUserAll(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return upsertUserAllHandler.handle(request);
    }

    @PostMapping(value = {"UserLoginApi", "8f6ea699aed499f418da995c10883c5a", "4496963d3652379707b2a1afb0cf8c79", "377ff7e625473cad3d09147f59ba0b37", "fbc94d02d7892138ccb857f69202cd2b"})
    public String userLoginApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return userLoginHandler.handle(request);
    }

    @PostMapping(value = {"UserLogoutApi", "8d897f835c24c54376aaff557ff12727", "6e3ca8eb92f9cef9e6028de6f7fede87", "0b1cc933b06715a320664029f0a97a3d", "00221b9322eaba32f1e695e3bb2fa871"})
    public String userLogoutApi(@ModelAttribute Map<String, Object> request) throws JsonProcessingException {
        return userLogoutHandler.handle(request);
    }

}
