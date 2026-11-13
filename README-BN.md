# RECHARGE HUB Android APK

এটি একটি Android demo APK project। GitHub Actions নিজে থেকে debug APK তৈরি করবে।

## APK নেওয়ার ধাপ
1. GitHub → Actions খুলুন।
2. Build RECHARGE HUB APK workflow-এর run খুলুন।
3. Artifacts থেকে RECHARGE-HUB-debug-APK ZIP ডাউনলোড করুন।
4. ZIP extract করে app-debug.apk install করুন।

## সতর্কতা
এই build শুধু demo। Real recharge/payment/wallet/commission চালু নেই। Production-এর আগে বৈধ recharge provider agreement/API, payment provider approval, KYC, secure backend, webhook verification, refund/reconciliation, privacy policy ও compliance review লাগবে। API secrets কখনো app-এ রাখবেন না।
