#!python2
import sys
import predict_labels_for_gui
import psycopg2 as psycopg2

host_url = 'castle.ewi.utwente.nl'
db = 'dpv2a136'
username = 'dpv2a136'
pas = 'SXgMxsey'


def get_report(report_id):
    conn = psycopg2.connect(host=host_url,database=db, user=username, password=pas)

    cur = conn.cursor()

    cur.execute('select report_content from AnnotationTool.reports where reports_pk = %s;', [report_id])

    try:
        return '<?xml version="1.0" ?> <radiology_reports>  <report> ' + cur.fetchone()[0] + ' </report> </radiology_reports>'
    except:
        return None


def annotate(report_id):
    return predict_labels_for_gui.mainFunc(get_report(report_id))


#id = sys.argv[1]
print(annotate(85))