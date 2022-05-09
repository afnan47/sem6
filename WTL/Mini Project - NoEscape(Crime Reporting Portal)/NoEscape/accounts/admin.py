from django.contrib import admin
from accounts.models import Applicant, Video, Camera

admin.site.site_header = "NoEscape Admin"
admin.site.site_title = "Welcome to NoEscape"
admin.site.index_title = "Welcome to this portal"


class ApplicantAdmin(admin.ModelAdmin):
    change_list_template = 'admin/accounts/account_change_list.html'

admin.site.register(Applicant)
admin.site.register(Video)
admin.site.register(Camera, ApplicantAdmin)
